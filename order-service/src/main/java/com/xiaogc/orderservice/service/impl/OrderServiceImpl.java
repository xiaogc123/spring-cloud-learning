package com.xiaogc.orderservice.service.impl;

import com.xiaogc.ordercommon.dao.OrderDao;
import com.xiaogc.ordercommon.dto.AccountReduceBalanceDTO;
import com.xiaogc.ordercommon.dto.ProductReduceStockDTO;
import com.xiaogc.ordercommon.dao.domain.OrderDO;
import com.xiaogc.orderservice.feign.AccountServiceFeignClient;
import com.xiaogc.orderservice.feign.ProductServiceFeignClient;
import com.xiaogc.orderservice.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xiaogc @Date 2020/5/4
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    AccountServiceFeignClient accountServic;
    @Resource
    ProductServiceFeignClient productService;
    @Resource
    OrderDao orderDao;

    /**
     * @param userId    用户编号
     * @param productId 产品编号
     * @param price     价格
     * @return 返回订单编号
     */
    @Override
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) {
        // 购买数量，暂时设置为 1。
        Integer amount = 1;

        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 扣减库存
        productService.reduceStock(
                ProductReduceStockDTO.builder().productId(productId).amount(amount).build());

        // 扣减余额
        accountServic.reduceBalance(
                AccountReduceBalanceDTO.builder().price(price).userId(userId).build());

        // 保存订单
        OrderDO order =
                OrderDO.builder().userId(userId).productId(productId).payAmount(amount * price).build();
        orderDao.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());
        return order.getId();
    }
}

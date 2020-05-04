package com.xiaogc.productservice.service.impl;

import com.xiaogc.ordercommon.dao.ProductDao;
import com.xiaogc.productservice.service.ProductService;
import io.seata.core.context.RootContext;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author xiaogc @Date 2020/5/4
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDao productDao;

    @Override
    @Transactional
    public void reduceStock(Long productId, Integer amount) throws Exception {
        log.info("[reduceStock] 当前 XID: {}", RootContext.getXID());
        // 检查库存
        checkStock(productId, amount);

        log.info("[reduceStock] 开始扣减 {} 库存", productId);
        // 扣减库存
        int updateCount = productDao.reduceStock(productId, amount);

        // 扣减失败抛出异常
        if (updateCount == 0) {
            log.warn("[reduceStock] 扣除 {} 库存失败", productId);
            throw new Exception("库存不足");
        }
        // 扣除失败
        log.info("[reduceStock] 扣除 {} 库存成功", productId);
    }

    /**
     * 检查库存
     *
     * @param productId
     * @param requiredAmount
     * @throws Exception
     */
    private void checkStock(Long productId, Integer requiredAmount) throws Exception {
        log.info("[checkStock] 检查 {} 库存", productId);
        Integer stock = productDao.getStock(productId);
        if (stock < requiredAmount) {
            log.warn("[checkStock] {} 库存不足，当前库存: {}", productId, stock);
            throw new Exception("库存不足");
        }
    }
}

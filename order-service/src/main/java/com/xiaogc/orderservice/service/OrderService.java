package com.xiaogc.orderservice.service;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param userId 用户编号
     * @param productId 产品编号
     * @param price 价格
     * @return 订单编号
     * @throws Exception 创建订单失败，抛出异常
     */
    Integer createOrder(Long userId, Long productId, Integer price);
}

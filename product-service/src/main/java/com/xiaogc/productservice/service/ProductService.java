package com.xiaogc.productservice.service;

/**
 * 商品 Service
 * @Author xiaogc
 * @Date 2020/5/4
 */
public interface ProductService {

    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    void reduceStock(Long productId, Integer amount) throws Exception;
}

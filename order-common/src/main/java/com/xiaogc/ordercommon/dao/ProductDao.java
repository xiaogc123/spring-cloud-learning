package com.xiaogc.ordercommon.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
@Mapper
public interface ProductDao {

    /**
     * 获取库存
     *
     * @param productId 商品编号
     * @return 库存
     */
    Integer getStock(@Param("productId") Long productId);

    /**
     * 扣减库存
     *
     * @param productId 商品编号
     * @param amount    扣减数量
     * @return 影响记录行数
     */
    int reduceStock(@Param("productId") Long productId, @Param("amount") Integer amount);
}

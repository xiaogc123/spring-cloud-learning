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
public interface AccountDao {

    /**
     * 获取账户余额
     *
     * @param userId 用户 ID
     * @return 账户余额
     */
    Integer getBalance(@Param("userId") Long userId);

    /**
     * 扣减余额
     *
     * @param price 需要扣减的数目
     * @return 影响记录行数
     */
    int reduceBalance(@Param("userId") Long userId,@Param("price") Integer price);
}

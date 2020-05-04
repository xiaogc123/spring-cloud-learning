package com.xiaogc.ordercommon.dao;

import com.xiaogc.ordercommon.dao.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
@Mapper
public interface OrderDao {

    /**
     * 插入订单记录
     *
     * @param order 订单
     * @return 影响记录数量
     */
    int saveOrder(OrderDO order);
}

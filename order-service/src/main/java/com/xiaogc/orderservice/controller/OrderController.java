package com.xiaogc.orderservice.controller;

import com.xiaogc.orderservice.service.OrderService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xiaogc @Date 2020/5/4
 */
@RequestMapping("order")
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("create")
    public Integer createOrder(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId,
            @RequestParam("price") Integer price)
            throws Exception {
        log.info("[createOrder] 收到下单请求,用户:{}, 商品:{}, 价格:{}", userId, productId, price);
        return orderService.createOrder(userId, productId, price);
    }
}

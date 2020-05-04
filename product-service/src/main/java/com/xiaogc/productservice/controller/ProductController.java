package com.xiaogc.productservice.controller;

import com.xiaogc.ordercommon.dto.ProductReduceStockDTO;
import com.xiaogc.productservice.service.ProductService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/reduce-stock")
    public void reduceStock(@RequestBody ProductReduceStockDTO productReduceStockDTO)
            throws Exception {
        log.info("[reduceStock] 收到减少库存请求, 商品:{}, 价格:{}", productReduceStockDTO.getProductId(),
                productReduceStockDTO.getAmount());
        productService.reduceStock(productReduceStockDTO.getProductId(), productReduceStockDTO.getAmount());
    }
}

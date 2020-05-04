package com.xiaogc.orderservice.feign;

import com.xiaogc.ordercommon.dto.ProductReduceStockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
@FeignClient(name = "product-service")
public interface ProductServiceFeignClient {

    @PostMapping("/product/reduce-stock")
    void reduceStock(@RequestBody ProductReduceStockDTO productReduceStockDTO);
}

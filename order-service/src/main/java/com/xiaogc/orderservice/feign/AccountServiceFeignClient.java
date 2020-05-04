package com.xiaogc.orderservice.feign;

import com.xiaogc.ordercommon.dto.AccountReduceBalanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */
@FeignClient(name = "account-service")
public interface AccountServiceFeignClient {

    @PostMapping("/account/reduce-balance")
    void reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO);
}

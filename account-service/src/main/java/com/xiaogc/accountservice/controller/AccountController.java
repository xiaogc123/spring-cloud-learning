package com.xiaogc.accountservice.controller;

import com.xiaogc.accountservice.service.AccountService;
import com.xiaogc.ordercommon.dto.AccountReduceBalanceDTO;
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
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/reduce-balance")
    public void reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO) throws Exception {
        log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}", accountReduceBalanceDTO.getUserId(),
                accountReduceBalanceDTO.getPrice());
        accountService.reduceBalance(accountReduceBalanceDTO.getUserId(), accountReduceBalanceDTO.getPrice());
    }
}

package com.xiaogc.accountservice.service.impl;

import com.xiaogc.accountservice.service.AccountService;
import com.xiaogc.ordercommon.dao.AccountDao;
import io.seata.core.context.RootContext;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author xiaogc
 * @Date 2020/5/4
 */

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional
    public void reduceBalance(Long userId, Integer price) throws Exception {
        log.info("[reduceBalance] 当前 XID: {}", RootContext.getXID());
        // 检查账户余额
        checkBalance(userId, price);

        log.info("[reduceBalance] 开始扣减用户 {} 余额", userId);
        // 扣减余额
        int updateCount = accountDao.reduceBalance(userId, price);
        // 余额扣减失败抛出异常
        if (updateCount == 0) {
            log.warn("[reduceBalance] 扣除用户 {} 余额失败", userId);
            throw new Exception("余额不足");
        }
        log.info("[reduceBalance] 扣除用户 {} 余额成功", userId);
    }

    private void checkBalance(Long userId, Integer price) throws Exception {
        log.info("[checkBalance] 检查用户 {} 余额", userId);
        Integer balance = accountDao.getBalance(userId);
        if (balance < price) {
            log.warn("[checkBalance] 用户 {} 余额不足，当前余额:{}", userId, balance);
            throw new Exception("余额不足");
        }
    }
}

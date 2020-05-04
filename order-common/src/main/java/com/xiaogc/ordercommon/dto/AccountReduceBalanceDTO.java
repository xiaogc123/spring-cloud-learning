package com.xiaogc.ordercommon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账户减少余额 DTO
 * @Author xiaogc
 * @Date 2020/5/4
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountReduceBalanceDTO {
    /** 用户编号 */
    private Long userId;

    /** 扣减金额 */
    private Integer price;
}

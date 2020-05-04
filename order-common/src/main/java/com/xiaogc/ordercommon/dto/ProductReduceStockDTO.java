package com.xiaogc.ordercommon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 商品减少库存 DTO @Author xiaogc @Date 2020/5/4 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReduceStockDTO {

  /** 商品编号 */
  private Long productId;
  /** 数量 */
  private Integer amount;
}

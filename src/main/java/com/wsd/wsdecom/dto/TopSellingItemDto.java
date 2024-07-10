package com.wsd.wsdecom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopSellingItemDto implements Serializable {
  @Serial
  private static final long serialVersionUID = -3663096980012553913L;

  private Long itemId;
  private String itemName;
  private BigDecimal totalSalesAmount;
  private Long totalSalesQuantity;
}

package com.wsd.wsdecom.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaxSaleDayResponseDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -3663096980012553913L;

  private String maxSaleDay;
}

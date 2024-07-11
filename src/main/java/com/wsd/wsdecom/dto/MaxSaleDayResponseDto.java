package com.wsd.wsdecom.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

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

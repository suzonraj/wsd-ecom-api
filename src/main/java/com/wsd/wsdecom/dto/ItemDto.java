package com.wsd.wsdecom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;
    String name;
    String description;
    BigDecimal price;
    LocalDateTime createdAT;
    private Long id;
}

package com.wsd.wsdecom.dto;

import com.wsd.wsdecom.entity.Order;
import jakarta.persistence.*;
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
public class SaleDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    private Long id;
    private OrderDto order;
    private LocalDateTime saleDate;
    private BigDecimal amount;
}

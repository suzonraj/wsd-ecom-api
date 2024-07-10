package com.wsd.wsdecom.dto;

import com.wsd.wsdecom.entity.Item;
import com.wsd.wsdecom.entity.Order;
import jakarta.persistence.*;
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
public class OrderItemDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    private Long id;
    private OrderDto order;
    private ItemDto item;
    private int quantity;
    private BigDecimal price;
}

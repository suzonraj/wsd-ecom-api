package com.wsd.wsdecom.dto;

import com.wsd.wsdecom.entity.Customer;
import com.wsd.wsdecom.entity.OrderItem;
import com.wsd.wsdecom.entity.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    private Long id;

    private CustomerDto customer;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private List<OrderItemDto> orderItems;
    private List<SaleDto> sales;
}

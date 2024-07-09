package com.wsd.wsdecom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    private Long id;
    private Long customerId;
    private CustomerDto customer;
    private ItemDto item;
    private LocalDateTime addedAt;
}

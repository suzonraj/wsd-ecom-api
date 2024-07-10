package com.wsd.wsdecom.dto;

import com.wsd.wsdecom.entity.Order;
import com.wsd.wsdecom.entity.Wishlist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
  @Serial
  private static final long serialVersionUID = -3663096980012553913L;

  private Long id;
  String name;
  String email;
  LocalDateTime createdAT;
  private List<OrderDto> orders;
  private List<WishlistDto> wishlists;
}

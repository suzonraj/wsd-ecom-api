package com.wsd.wsdecom.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
  @Serial
  private static final long serialVersionUID = -3663096980012553913L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  String name;

  @Column(name = "email")
  String email;

  @Column(name = "created_at")
  LocalDateTime createdAT;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Order> orders;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Wishlist> wishlists;
}

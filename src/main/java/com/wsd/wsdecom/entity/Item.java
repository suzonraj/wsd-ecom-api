package com.wsd.wsdecom.entity;

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
@Entity
@Table(name = "items")
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "price")
    BigDecimal price;
    @Column(name = "created_at")
    LocalDateTime createdAT;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

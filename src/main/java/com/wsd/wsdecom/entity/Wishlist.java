package com.wsd.wsdecom.entity;

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
@Entity
@Table(name = "wishlist")
public class Wishlist implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "added_at", nullable = false)
    private LocalDateTime addedAt;


}

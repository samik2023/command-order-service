package com.bank.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CQRS_ORDERS_JPA")
public class CommandOrder {


    public CommandOrder(Long orderId, Long productId, String userId, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long productId;
    private String userId;
    private String status;
}


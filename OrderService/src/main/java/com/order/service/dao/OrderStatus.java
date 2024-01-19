package com.order.service.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_STATUS")
@Data
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;

    private String currentStatus;

    private Boolean orderActive;

    private LocalDateTime lastUpdated;

 /*   @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;*/

    // Getters, setters, constructors, etc.
}

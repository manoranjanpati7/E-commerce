package com.order.service.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "customer_order")
@Data
public class Order extends   AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Double orderPrice;

    private String carrierName;

    private Boolean isActive;


    private String orderType;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderPart> orderParts;


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Address address;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderPrice=" + orderPrice +
                ", carrierName='" + carrierName + '\'' +
                ", isActive=" + isActive +
                ", orderType='" + orderType + '\'' +
                ", orderParts=" + orderParts +
                ", address=" + address +
                '}';
    }
// Getters, setters, constructors, etc.
}

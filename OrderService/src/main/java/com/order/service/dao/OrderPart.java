package com.order.service.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ORDER_PART")
@Data
public class OrderPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderPartId")
    private Long orderPartId;

    @Column(name = "ItemId")
    private Long itemId;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "price")
    private Double price;

    @Column(name = "ItemQuantity")
    private int itemQuantity;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public String toString() {
        return "OrderPart{" +
                "orderPartId=" + orderPartId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", itemQuantity=" + itemQuantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
// Getters, setters, constructors, etc.
}

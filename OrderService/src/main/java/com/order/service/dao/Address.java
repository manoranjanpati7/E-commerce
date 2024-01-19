package com.order.service.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String customerName;


    private String street;


    private String city;

    @Column(name = "ZipCode")
    private String zipCode;

    @Column(name = "Country")
    private String country;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", customerName='" + customerName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Getters, setters, constructors, etc.
}

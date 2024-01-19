package com.order.service.responceDTO;

import lombok.Data;

@Data
public class OrderPartResponseDTO {
    private Long orderPartId;
    private  Long itemId;
    private String itemName;
    private int itemQuantity;
    private String imageUrl;
    private double price;
}

package com.order.service.requestdto;

import com.order.service.dao.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPartRequestDTO {
    private Long orderPartId;
    private  Long itemId;
    private String itemName;
    private int itemQuantity;
    private String imageUrl;
    private double price;
}

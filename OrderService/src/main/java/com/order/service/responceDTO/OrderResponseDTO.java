package com.order.service.responceDTO;

import com.order.service.dao.Address;
import com.order.service.dao.OrderPart;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private Long customerId;
    private String orderType;
    private Double orderPrice;
    private String carrierName;
    private List<OrderPartResponseDTO> orderParts;
    private AddressResponseDTO address;
    private Boolean isActive;
}

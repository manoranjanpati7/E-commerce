package com.order.service.responceDTO;

import lombok.Data;

@Data
public class AddressResponseDTO {
    private Long addressId;
    private String customerName;
    private String street;
    private String city;
    private String zipCode;
    private String country;
}

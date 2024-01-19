package com.order.service.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequestDTO {
    private Long addressId;
    private String customerName;
    private String street;
    private String city;
    private String zipCode;
    private String country;


}

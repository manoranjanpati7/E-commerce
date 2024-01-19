package com.order.service.requestdto;

import com.order.service.constant.CommonValidationConstant;
import com.order.service.dao.Address;
import com.order.service.dao.OrderPart;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private Long orderId;
    @NotNull(message = CommonValidationConstant.INVALID_CUSTOMER_ID)
    @NotBlank(message = CommonValidationConstant.INVALID_CUSTOMER_ID)
    private Long customerId;
    private String orderType;
    private String carrierName;
    private List<OrderPartRequestDTO> orderParts;
    private AddressRequestDTO address;
    private Boolean isActive;



}

package com.order.service.mapper;

import com.order.service.requestdto.OrderRequestDTO;
import com.order.service.responceDTO.OrderResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OrderServiceMapper {

//    @Mapping(target = "desiredPropertyNameInResponseDTO", source = "correspondingPropertyInRequestDTO")

//    @Mapping(target = "orderParts",source = "orderPartsResponse")
//    @Mapping(target = "address",source = "addressResponse")
    OrderResponseDTO orderRequestDtoToOrderResponseDTO(OrderRequestDTO orderRequestDTO);
}

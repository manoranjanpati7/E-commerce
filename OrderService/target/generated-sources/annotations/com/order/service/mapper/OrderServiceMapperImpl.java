package com.order.service.mapper;

import com.order.service.requestdto.AddressRequestDTO;
import com.order.service.requestdto.OrderPartRequestDTO;
import com.order.service.requestdto.OrderRequestDTO;
import com.order.service.responceDTO.AddressResponseDTO;
import com.order.service.responceDTO.OrderPartResponseDTO;
import com.order.service.responceDTO.OrderResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-08T01:27:10+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OrderServiceMapperImpl implements OrderServiceMapper {

    @Override
    public OrderResponseDTO orderRequestDtoToOrderResponseDTO(OrderRequestDTO orderRequestDTO) {
        if ( orderRequestDTO == null ) {
            return null;
        }

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setOrderId( orderRequestDTO.getOrderId() );
        orderResponseDTO.setCustomerId( orderRequestDTO.getCustomerId() );
        orderResponseDTO.setOrderType( orderRequestDTO.getOrderType() );
        orderResponseDTO.setCarrierName( orderRequestDTO.getCarrierName() );
        orderResponseDTO.setOrderParts( orderPartRequestDTOListToOrderPartResponseDTOList( orderRequestDTO.getOrderParts() ) );
        orderResponseDTO.setAddress( addressRequestDTOToAddressResponseDTO( orderRequestDTO.getAddress() ) );
        orderResponseDTO.setIsActive( orderRequestDTO.getIsActive() );

        return orderResponseDTO;
    }

    protected OrderPartResponseDTO orderPartRequestDTOToOrderPartResponseDTO(OrderPartRequestDTO orderPartRequestDTO) {
        if ( orderPartRequestDTO == null ) {
            return null;
        }

        OrderPartResponseDTO orderPartResponseDTO = new OrderPartResponseDTO();

        orderPartResponseDTO.setOrderPartId( orderPartRequestDTO.getOrderPartId() );
        orderPartResponseDTO.setItemId( orderPartRequestDTO.getItemId() );
        orderPartResponseDTO.setItemName( orderPartRequestDTO.getItemName() );
        orderPartResponseDTO.setItemQuantity( orderPartRequestDTO.getItemQuantity() );
        orderPartResponseDTO.setImageUrl( orderPartRequestDTO.getImageUrl() );
        orderPartResponseDTO.setPrice( orderPartRequestDTO.getPrice() );

        return orderPartResponseDTO;
    }

    protected List<OrderPartResponseDTO> orderPartRequestDTOListToOrderPartResponseDTOList(List<OrderPartRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderPartResponseDTO> list1 = new ArrayList<OrderPartResponseDTO>( list.size() );
        for ( OrderPartRequestDTO orderPartRequestDTO : list ) {
            list1.add( orderPartRequestDTOToOrderPartResponseDTO( orderPartRequestDTO ) );
        }

        return list1;
    }

    protected AddressResponseDTO addressRequestDTOToAddressResponseDTO(AddressRequestDTO addressRequestDTO) {
        if ( addressRequestDTO == null ) {
            return null;
        }

        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();

        addressResponseDTO.setAddressId( addressRequestDTO.getAddressId() );
        addressResponseDTO.setCustomerName( addressRequestDTO.getCustomerName() );
        addressResponseDTO.setStreet( addressRequestDTO.getStreet() );
        addressResponseDTO.setCity( addressRequestDTO.getCity() );
        addressResponseDTO.setZipCode( addressRequestDTO.getZipCode() );
        addressResponseDTO.setCountry( addressRequestDTO.getCountry() );

        return addressResponseDTO;
    }
}

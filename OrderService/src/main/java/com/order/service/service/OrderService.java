package com.order.service.service;

import com.order.service.requestdto.OrderRequestDTO;
import com.order.service.responceDTO.BaseResponse;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface OrderService {
    BaseResponse createOrder(OrderRequestDTO orderRequestDTO) throws BadRequestException;
     BaseResponse getAllOrders();
    BaseResponse getOrderById(Long orderId);
}

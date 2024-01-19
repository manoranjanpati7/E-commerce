package com.order.service.controller;

import com.order.service.requestdto.OrderRequestDTO;
import com.order.service.responceDTO.BaseResponse;
import com.order.service.service.OrderService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public BaseResponse createOrder(@RequestBody OrderRequestDTO orderRequestDTO)	throws BadRequestException {
      return orderService.createOrder(orderRequestDTO);
        }

    @GetMapping("/orders")
    public BaseResponse getAllOrder(){
        return orderService.getAllOrders();
    }
    @GetMapping("/order/{orderId}")
    public BaseResponse getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }


}

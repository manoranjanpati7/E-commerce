package com.order.service.service;

import com.order.service.constant.CommonValidationConstant;
import com.order.service.dao.Address;
import com.order.service.dao.Order;
import com.order.service.dao.OrderPart;
import com.order.service.mapper.OrderServiceMapper;
import com.order.service.repository.AddressRepository;
import com.order.service.repository.OrderPartRepository;
import com.order.service.repository.OrderRepository;
import com.order.service.repository.OrderStatusRepository;
import com.order.service.requestdto.AddressRequestDTO;
import com.order.service.requestdto.OrderPartRequestDTO;
import com.order.service.requestdto.OrderRequestDTO;
import com.order.service.responceDTO.BaseResponse;
import com.order.service.responceDTO.OrderResponseDTO;
import com.order.service.utility.OrderUtility;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPartRepository orderPartRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private AddressRepository addressRepository;
        @Autowired
    private OrderServiceMapper orderServiceMapper;
    @Value("${order.status.paid}")
    private String orderTypes;

    @Override
    public BaseResponse createOrder(OrderRequestDTO orderRequestDTO) throws BadRequestException {
        Order existingOrder = orderRepository.findByIdAndIsActiveTrue(orderRequestDTO.getOrderId());
        if (existingOrder != null) {
            throw new BadRequestException(CommonValidationConstant.EXITING_ORDER_ID);
        }

        Order order = new Order();
        order.setCustomerId(orderRequestDTO.getCustomerId());
        order.setOrderType(orderRequestDTO.getOrderType());
        order.setCarrierName(orderRequestDTO.getCarrierName());
        order.setIsActive(orderRequestDTO.getIsActive());
        List<OrderPartRequestDTO> orderParts = orderRequestDTO.getOrderParts();
        List<OrderPart> orderPartList= new ArrayList<>();


        Double totalPrice = 0.0;
        if (orderParts != null && !orderParts.isEmpty()) {
            for (OrderPartRequestDTO orderPartRequest : orderParts) {
                Double partPrice = orderPartRequest.getPrice() * orderPartRequest.getItemQuantity(); // Multiply price by quantity
                totalPrice += partPrice;
                OrderPart part=new OrderPart();
                part.setImageUrl("xyz.com");
                part.setPrice(orderPartRequest.getPrice());
                part.setItemId(orderPartRequest.getItemId());
                part.setOrder(order);
                part.setItemName(orderPartRequest.getItemName());
                part.setItemQuantity(orderPartRequest.getItemQuantity());
                orderPartList.add(part);
            }
            order.setOrderPrice(totalPrice);
            order.setOrderParts(orderPartList);

        }
        AddressRequestDTO address = orderRequestDTO.getAddress();
        Address address1=new Address();
        if (address != null) {
            address1.setCountry(address.getCountry());
            address1.setCity(address.getCity());
            address1.setStreet(address.getStreet());
            address1.setZipCode(address.getZipCode());
            address1.setCustomerName(address.getCustomerName());
            address1.setOrder(order);
            order.setAddress(address1);
        }

            orderRepository.save(order);

            OrderResponseDTO responseDTO = new OrderResponseDTO();
            responseDTO = orderServiceMapper.orderRequestDtoToOrderResponseDTO(orderRequestDTO);
            responseDTO.setOrderPrice(order.getOrderPrice());
            BaseResponse response = new BaseResponse();
            response.setData(responseDTO);
            response.setResult(OrderUtility.getResult());
            return response;
        }

    @Override
    public BaseResponse getAllOrders() {
        List<Order> orders = orderRepository.findAllByIsActiveTrue(); // Assuming you have a method in OrderRepository to fetch all active orders

        List<OrderResponseDTO> orderResponseDTOs = orders.stream()
                .map(orderServiceMapper::orderRequestDtoToOrderResponseDTO)
                .collect(Collectors.toList());

        BaseResponse response = new BaseResponse();
        response.setData(orderResponseDTOs);
        response.setResult(OrderUtility.getResult());

        return response;

    }

    @Override
    public BaseResponse getOrderById(Long orderId) {
        Order order = orderRepository.findByIdAndIsActiveTrue(orderId);

        if (order == null) {
            BaseResponse notFoundResponse = new BaseResponse();
            notFoundResponse.setData("Order not found");
//            notFoundResponse.setResult(,"Order not found");
            return notFoundResponse;
        }

        OrderResponseDTO orderResponseDTO = orderServiceMapper.orderRequestDtoToOrderResponseDTO(OrderRequestDTO);
        orderResponseDTO.setOrderPrice(order.getOrderPrice());

        BaseResponse response = new BaseResponse();
        response.setData(orderResponseDTO);
        response.setResult(OrderUtility.getResult());
        return response;
    }

}
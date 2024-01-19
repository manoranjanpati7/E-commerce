package com.order.service.repository;

import com.order.service.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByIdAndIsActiveTrue(Long orderId);

    List<Order> findAllByIsActiveTrue();
}

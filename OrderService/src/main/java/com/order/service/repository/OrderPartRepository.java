package com.order.service.repository;


import com.order.service.dao.OrderPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPartRepository extends JpaRepository<OrderPart, Long> {
}

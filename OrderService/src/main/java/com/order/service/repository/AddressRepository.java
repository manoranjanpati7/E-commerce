package com.order.service.repository;

import com.order.service.dao.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address ,Long> {
}

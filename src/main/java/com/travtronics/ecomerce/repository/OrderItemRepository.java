package com.travtronics.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travtronics.ecomerce.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

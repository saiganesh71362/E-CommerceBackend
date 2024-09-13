package com.travtronics.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travtronics.ecomerce.entity.Order;

public interface OrderRepository extends  JpaRepository<Order,Long>{

}

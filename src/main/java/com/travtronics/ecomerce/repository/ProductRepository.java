package com.travtronics.ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travtronics.ecomerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);

}

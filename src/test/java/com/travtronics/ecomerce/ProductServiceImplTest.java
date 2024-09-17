package com.travtronics.ecomerce;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.repository.ProductRepository;
import com.travtronics.ecomerce.serviceimpl.ProductServiceImpl;

class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

//	@Test
//	void test_getAllProducts() {
//		Product product1 = new Product();
//		product1.setName("Laptop");
//		product1.setDescription("A high-performance laptop.");
//		product1.setCategory("Electronics");
//		product1.setPrice(1200.00);
//		product1.setStockQuantity(50);
//
//		Product product2 = new Product();
//		product2.setName("Smartphone");
//		product2.setDescription("Latest model smartphone.");
//		product2.setCategory("Electronics");
//		product2.setPrice(800.00);
//		product2.setStockQuantity(100);
//
//		Product product3 = new Product();
//		product3.setName("Office Chair");
//		product3.setDescription("Ergonomic office chair.");
//		product3.setCategory("Furniture");
//		product3.setPrice(150.00);
//		product3.setStockQuantity(200);
//
//		productRepository.save(product1);
//		productRepository.save(product2);
//		productRepository.save(product3);
//	}
}

package com.travtronics.ecomerce.service;

import java.util.List;

import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.globalexceptionhandle.IdNotFoundException;

public interface ProductService {
	
	Product createProduct(Product product) throws Exception;

	Product updateProduct(Long id, Product product) throws IdNotFoundException;

	Product getProductById(Long id) throws IdNotFoundException;

	List<Product> getAllProducts();

	Boolean deleteProduct(Long id) throws IdNotFoundException;

	List<Product> searchProducts(String name, String category, int page, int size);

}

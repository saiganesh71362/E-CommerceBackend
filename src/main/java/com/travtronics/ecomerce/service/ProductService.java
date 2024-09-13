package com.travtronics.ecomerce.service;

import java.util.List;

import com.travtronics.ecomerce.dto.ProductDTO;
import com.travtronics.ecomerce.entity.Product;

public interface ProductService {
	
	Product createProduct(Product product) throws Exception;

	Product updateProduct(Long id, ProductDTO productDTO) throws Exception;

	Product getProductById(Long id) throws Exception;

	List<Product> getAllProducts();

	Boolean deleteProduct(Long id) throws Exception;

	List<Product> searchProducts(String name, String category, int page, int size);

}

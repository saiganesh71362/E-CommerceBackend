package com.travtronics.ecomerce.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travtronics.ecomerce.dto.ProductDTO;
import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.serviceimpl.ProductServiceImpl;

@RestController
public class ProductServiceController {

	ProductServiceImpl productServiceImpl;

	public ProductServiceController(ProductServiceImpl productServiceImpl) {
		super();
		this.productServiceImpl = productServiceImpl;
	}

	@PostMapping("/newProduct")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {
		Product createProduct = productServiceImpl.createProduct(product);
		return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
	}

	@GetMapping("productById/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) throws Exception {
		Product product = productServiceImpl.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.FOUND);
	}

	@PutMapping("updateProductById/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO)
			throws Exception {
		Product product = productServiceImpl.updateProduct(id, productDTO);
		return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("deleteProductById/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) throws Exception {
		Boolean deleteProduct = productServiceImpl.deleteProduct(id);
		return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
	}

	@GetMapping
	public List<Product> searchProducts(@RequestParam(required = false) String name,
			@RequestParam(required = false) String category, Pageable pageable) {
//		Page<Product> products = productServiceImpl.searchProducts(name, category, pageable);
//		return ResponseEntity.ok(products);
		return null;
	}
}

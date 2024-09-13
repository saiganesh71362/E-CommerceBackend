package com.travtronics.ecomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travtronics.ecomerce.dto.ProductDTO;
import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.repository.ProductRepository;
import com.travtronics.ecomerce.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	// Using Constructor Injection No Need @Autowire Annotations
	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	@Transactional
	public Product createProduct(Product product) throws Exception {
		if (product != null) {
			return productRepository.save(product);

		}
		throw new Exception("Product is null and cannot be created.");
	}

	@Override
	@Transactional
	public Product updateProduct(Long id, ProductDTO productDTO) throws Exception {
		Product product = getProductById(id);
		product.setName(productDTO.getName());
		product.setCategory(productDTO.getCategory());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setStockQuantity(productDTO.getStockQuantity());
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) throws Exception {

		Optional<Product> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();

		}
		throw new Exception("No Product :" + id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean deleteProduct(Long id) throws Exception {
		Optional<Product> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		throw new Exception("Id Not Found :" + id);
	}

	@Override
	public List<Product> searchProducts(String name, String category, int page, int size) {
		return null;

	}

//	if (name != null) {
//        return productRepository.findByNameContaining(name, pageable);
//    }
//    if (category != null) {
//        return productRepository.findByCategory(category, pageable);
//    }
//    return productRepository.findAll(pageable);
}

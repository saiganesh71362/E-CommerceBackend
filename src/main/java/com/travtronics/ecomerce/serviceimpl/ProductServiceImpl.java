package com.travtronics.ecomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travtronics.ecomerce.appconstants.EcommerceConstants;
import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.globalexceptionhandle.IdNotFoundException;
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
	public Product createProduct(Product product) throws IdNotFoundException {
		if (product != null) {
			return productRepository.save(product);

		}
		throw new IdNotFoundException("Product Is Null And Cannot Be Created.");
	}

	@Override
	@Transactional
	public Product updateProduct(Long id, Product product) throws IdNotFoundException {
		Product exsitProduct = getProductById(id);
		exsitProduct.setName(product.getName());
		exsitProduct.setCategory(product.getCategory());
		exsitProduct.setDescription(product.getDescription());
		exsitProduct.setPrice(product.getPrice());
		exsitProduct.setStockQuantity(product.getStockQuantity());
		return productRepository.save(exsitProduct);
	}

	@Override
	public Product getProductById(Long id) throws IdNotFoundException {

		Optional<Product> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();

		}
		throw new IdNotFoundException(EcommerceConstants.PRODUCT_ID_NOT_FOUND + id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean deleteProduct(Long id) throws IdNotFoundException {
		Optional<Product> findById = productRepository.findById(id);
		if (findById.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		throw new IdNotFoundException(EcommerceConstants.PRODUCT_ID_NOT_FOUND + id);
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

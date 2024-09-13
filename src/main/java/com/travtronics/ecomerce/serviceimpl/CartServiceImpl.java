package com.travtronics.ecomerce.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travtronics.ecomerce.dto.CartItemDTO;
import com.travtronics.ecomerce.entity.Cart;
import com.travtronics.ecomerce.entity.CartItem;
import com.travtronics.ecomerce.entity.Product;
import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.repository.CartRepository;
import com.travtronics.ecomerce.service.CartService;
import com.travtronics.ecomerce.service.ProductService;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private ProductService productService;

	public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
		super();
		this.cartRepository = cartRepository;
		this.productService = productService;
	}

	@Override
	public Cart getCartByUserId(Long userId) throws Exception
	{
		Optional<Cart> findById = cartRepository.findById(userId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		throw new Exception("User Id Not FOund :"+userId);
	}

	@Override
	public Cart addItemToCart(Long userId, CartItemDTO cartItemDTO) throws Exception {
		Optional<Cart> cartOptional = cartRepository.findByUserId(userId);

		// Get the product from the product service
		Product product = productService.getProductById(cartItemDTO.getProductId());

		// Initialize the cart, create a new one if it doesn't exist
		Cart cart;
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
		} else {
			cart = new Cart(); // Creating a new cart for the user
			cart.setUser(new User(userId)); // Assuming User is a reference
		}

		// Create a new CartItem and add it to the cart
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItem.setPrice(product.getPrice() * cartItemDTO.getQuantity());
		cartItem.setCart(cart); // Set the reference to the cart

		cart.getCartItems().add(cartItem); // Add the cart item to the cart

		// Recalculate the total price of the cart
		cart.setToatlPrice(cart.getCartItems().stream().mapToDouble(item -> item.getPrice()).sum());

		// Save and return the updated cart
		return cartRepository.save(cart);
	}

	@Override
	public Cart removeItemFromCart(Long userId, Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}

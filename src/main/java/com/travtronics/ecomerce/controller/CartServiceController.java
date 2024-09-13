package com.travtronics.ecomerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travtronics.ecomerce.dto.CartItemDTO;
import com.travtronics.ecomerce.entity.Cart;
import com.travtronics.ecomerce.entity.Order;
import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.serviceimpl.CartServiceImpl;

@RestController
public class CartServiceController {

	CartServiceImpl cartServiceImpl;

	public CartServiceController(CartServiceImpl cartServiceImpl) {
		super();
		this.cartServiceImpl = cartServiceImpl;
	}

	@PostMapping("/add")
	public ResponseEntity<Cart> addItemToCart(@AuthenticationPrincipal User user, @RequestBody CartItemDTO cartItemDTO)
			throws Exception {
		Cart cart = cartServiceImpl.addItemToCart(user.getId(), cartItemDTO);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}

	@DeleteMapping("/remove/{productId}")
	public ResponseEntity<Void> removeItemFromCart(@AuthenticationPrincipal User user, @PathVariable Long productId) {
		cartServiceImpl.removeItemFromCart(user.getId(), productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/checkout")
	public ResponseEntity<Order> checkout(@AuthenticationPrincipal User user) {
//		Order order = cartServiceImpl.(user.getId());
//		return ResponseEntity.ok(order);
		return null;
	}

}

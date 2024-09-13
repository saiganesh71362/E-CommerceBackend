package com.travtronics.ecomerce.service;

import com.travtronics.ecomerce.dto.CartItemDTO;
import com.travtronics.ecomerce.entity.Cart;

public interface CartService {
	Cart getCartByUserId(Long userId) throws Exception;

	Cart addItemToCart(Long userId, CartItemDTO cartItemDTO) throws Exception;

	Cart removeItemFromCart(Long userId, Long productId);


}

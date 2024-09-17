package com.travtronics.ecomerce.service;

import com.travtronics.ecomerce.dto.CartItemDTO;
import com.travtronics.ecomerce.entity.Cart;
import com.travtronics.ecomerce.globalexceptionhandle.IdNotFoundException;
import com.travtronics.ecomerce.globalexceptionhandle.ItemAddFaildException;

public interface CartService {
	Cart getCartByUserId(Long userId) throws IdNotFoundException;

	Cart addItemToCart(Long userId, CartItemDTO cartItemDTO) throws ItemAddFaildException;

	Cart removeItemFromCart(Long userId, Long productId);


}

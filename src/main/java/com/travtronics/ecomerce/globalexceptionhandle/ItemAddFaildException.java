package com.travtronics.ecomerce.globalexceptionhandle;

public class ItemAddFaildException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemAddFaildException(String message) {
		super(message);
	}
}

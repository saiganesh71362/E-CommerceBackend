package com.travtronics.ecomerce.globalexceptionhandle;

public class UserUpdateFaildException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	UserUpdateFaildException(String message)
	{
		super(message);
	}

}

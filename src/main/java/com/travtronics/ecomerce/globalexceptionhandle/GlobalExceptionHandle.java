package com.travtronics.ecomerce.globalexceptionhandle;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ExceptionMessage> HandleIdNotFoundException(IdNotFoundException idNotFoundException,
			WebRequest webRequest) {
		ExceptionMessage message = new ExceptionMessage(new java.util.Date(), idNotFoundException.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ItemAddFaildException.class)
	public ResponseEntity<ExceptionMessage> HandleItemAddFaildException(ItemAddFaildException itemAddFaildException,
			WebRequest webRequest) {
		ExceptionMessage message = new ExceptionMessage(new Date(), itemAddFaildException.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserUpdateFaildException.class)
	public ResponseEntity<ExceptionMessage> HandleUserUpdateFaildException(
			UserUpdateFaildException updateFaildException, WebRequest webRequest) {
		ExceptionMessage message = new ExceptionMessage(new Date(), updateFaildException.getMessage(),
				webRequest.getDescription(false));
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}

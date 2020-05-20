package com.hcl.ospoclogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> UserErrorException(UserException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(700);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

package com.hcl.ospoclogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.ospoclogin.utlity.AppConstant;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> UserErrorException(UserException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(AppConstant.USER_NOT_EXIST_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserPassword.class)
	public ResponseEntity<ErrorResponse> UserPasswordException(UserPassword ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(AppConstant.PASSWORD_NOT_MATCHING_STATUS);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

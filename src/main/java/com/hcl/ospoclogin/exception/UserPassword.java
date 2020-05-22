package com.hcl.ospoclogin.exception;

public class UserPassword extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public UserPassword(String message) {
		super(message);

	}

}

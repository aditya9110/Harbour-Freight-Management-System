package com.demo.ftr.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String errors) {
		super(errors);
	}
}

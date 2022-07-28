package com.demo.ftr.exception;

public class InvalidDetailsException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidDetailsException() {
		super();
	}
	public InvalidDetailsException(String errors) {
		super(errors);
	}
}

package com.terminalMS.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.terminalMS.Exception.TerminalNotFound;

public class GlobalExceptionHandler {
	@ExceptionHandler(TerminalNotFound.class)
	public ResponseEntity<ErrorMessage> TerminalNotfoundHandler(TerminalNotFound ex) {
		ErrorMessage msg = new ErrorMessage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

		// working fine
	}
}

package com.demo.ftr.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.ftr.exception.VehicleNotfound;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(VehicleNotfound.class) 
	public ResponseEntity<ErrorMeassage> VehicleNotfoundHandler(VehicleNotfound ex){
		ErrorMeassage msg = new ErrorMeassage();
		msg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		msg.setMessage(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		
		//working fine
	}
	
	 
	

}

package com.example.model;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

	
	
	@ExceptionHandler(UserException.class)
	public ErrorResponse<String> handleRegisterException(UserException ex) {
		
		return new ErrorResponse<String>(LocalDateTime.now(), "ERROR",ex.getMessage());
		
		
	}
	
}
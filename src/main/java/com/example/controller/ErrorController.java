package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserException;

@RestController
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("/notoken")
	public void controlFilterNotoken() {
		throw new UserException("No token.");
	}
	
	@GetMapping("/tokenwrong")
	public void controlFilterTokenWrong() {
		throw new UserException("Token is wrong.");
	}
	
	@GetMapping("/tokentimeout")
	public void controlFilterTokenTimeout() {
		throw new UserException("Token time out.");
	}
	
	
}
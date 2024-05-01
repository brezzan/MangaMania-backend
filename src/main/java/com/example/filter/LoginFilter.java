package com.example.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.filter.LoginFilter;
import com.example.model.User;
import com.example.service.UserService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	UserService srv;
	
	Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
	public LoginFilter(UserService srv) {
		this.srv = srv;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		String token = req.getHeader("token");
		if(token==null) {
			res.sendRedirect("/error/notoken");
		}else {
			
			User userFound = srv.getUserByToken(token);
			
			if(userFound==null) {
				
				res.sendRedirect("/error/tokenwrong");
			}else {
				if(LocalDateTime.now().isAfter(userFound.getToken().getTimeOut())) {
					res.sendRedirect("/error/tokentimeout");
				}
			}

			
		}
		
		
		logger.info("Filter invokedd..............");
		
		chain.doFilter(request, response);
		
		
		
	}

}

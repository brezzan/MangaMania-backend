package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.filter.LoginFilter;
import com.example.service.UserService;


@SpringBootApplication
public class MangaManiaApplication  {
	
	
	Logger logger = LoggerFactory.getLogger(MangaManiaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MangaManiaApplication.class, args);
	}
	
	@Bean
	FilterRegistrationBean<LoginFilter> loginFilter(UserService userService){
	    FilterRegistrationBean<LoginFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new LoginFilter(userService));
	    registrationBean.addUrlPatterns("/user/userinfo/*");
	    registrationBean.addUrlPatterns("/contact/*");
	    registrationBean.setOrder(1);
	        
	    return registrationBean;    
	}

	 
}

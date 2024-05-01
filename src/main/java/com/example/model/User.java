package com.example.model;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document
public class User {

	@Id
	private String userId;
	
	@Indexed(unique = true)
	private String username;
	
	@Indexed(unique = true)
	private String mail;
	
	private Token token;
	
	private String password;
	

	
	
	public User(String username, String mail, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}

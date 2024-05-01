package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserException;
import com.example.model.LoginInfo;
import com.example.model.Token;
import com.example.model.User;

import com.example.repo.UserRepo;


@Service
public class UserService {

	
	@Autowired private UserRepo userRepo;
	
	
	public User loginUser(LoginInfo loginInfo) throws Exception{
		Optional<User> userTemp = userRepo.findByUsernameAndPassword(loginInfo.getUsername(), loginInfo.getPassword());
		User userFound = userTemp.orElse(null);
		
		if(userFound == null) {
			throw new UserException("Username or password is wrong.");
		}
		
		String tokenText = new ObjectId().toString();
		Token token = new Token(tokenText,LocalDateTime.now().plusDays(100));
		userFound.setToken(token);
		userFound = userRepo.save(userFound);

		return userFound;
		
	}
	
	
	public boolean registerUser(User user) throws Exception {
		
		try {
			userRepo.save(user);
		} catch (org.springframework.dao.DuplicateKeyException e) {
			throw new UserException("Username already exists.");
		}catch (Exception e) {
			throw e;
		}
		
		return true;
	}
	
	public User getUserByToken(String tokenStr) {
		User userFound = userRepo.findByTokenString(tokenStr);
		return userFound;
		
	}
	
	public void destroyToken(String tokenStr) {
		User userFound = userRepo.findByTokenString(tokenStr);
		
		userFound.setToken(null);
		
		userRepo.save(userFound);
		
	}
	

	
	
	
	
}
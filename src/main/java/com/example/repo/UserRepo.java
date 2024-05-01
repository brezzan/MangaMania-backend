package com.example.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.User;

public interface UserRepo extends MongoRepository<User, String> {
	
	 @Override
	 public Optional<User> findById(String userId);

	
	 @Override
	 public List<User> findAll();

	
	 public Optional<User> findByUsername(String username);
	 
	 
	 public Optional<User> findByMail(String mail);

	 
	 public Optional<User> findByUsernameAndPassword(String username,String password);
		
	 @Query("{'token.token':?0}")
	 public User findByTokenString(String tokenStr);
	 
	 public Optional<User> findByUsernameAndMail(String username,String mail );


}

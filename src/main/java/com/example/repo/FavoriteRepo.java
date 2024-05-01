package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.Favorite;

public interface FavoriteRepo extends MongoRepository<Favorite,String>{
	@Override
    public List<Favorite> findAll();
    
    @Override
    public Optional<Favorite> findById(String favId);
    
    public Favorite findByUser(String userId);
    
    public Favorite findByUser_UserId(String token);
}

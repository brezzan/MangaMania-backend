package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.Manga;


public interface MangaRepo extends MongoRepository<Manga,String> {
	
    @Override
    public List<Manga> findAll();

    public List<Manga> findByTitleEn(String titleEn);
    
    public List<Manga> findByTitleOv(String titleOv);
    
    public List<Manga> findByTitleEnContainsIgnoreCase(String name);
    
    public List<Manga> findByTitleOvContainsIgnoreCase(String name);


    public Optional<Manga> findById(String id);

    @Query(value = "{'information.authors.name': ?0}")
    public List<Manga> findByAuthorName(String authorName);

	
}

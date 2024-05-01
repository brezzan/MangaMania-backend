package com.example.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import com.example.model.Chapter;


public interface ChapterRepo extends MongoRepository<Chapter, String>{
	
	
	@Override
    public List<Chapter> findAll();

    public List<Chapter> findByChapterName(String name);
    
    public List<Chapter> findByChapterNameContainsIgnoreCase(String name);
                       
    public List<Chapter> findByChapterNumber(int num);
    
    public List<Chapter> findByManga_MangaId(String mangaId);
    
    Optional<Chapter> findById(String id);


}

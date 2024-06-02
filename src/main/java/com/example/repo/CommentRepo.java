package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.example.model.Comment;

public interface CommentRepo extends MongoRepository<Comment,String>{
	
	@Override
    public List<Comment> findAll();
    
    @Override
    public Optional<Comment> findById(String commentId);
 

    public List<Comment> findByUserCommented_UserId(String userId);
    
    public List<Comment> findByChapter_ChapterId(String chapterId);

   
    public List<Comment> findByRootComment(String rootCommentId);
    
    
    // test if these work 
    
    @Query(value = "{'rootComment': null}")  // fields = "{ 'rootComment' : 1 }" ? 
    public List<Comment> findDistinctRootComments();  // return me distinct root comments,a root comment has no root so null 
    
    
    public List<Comment> findByRootComment_CommentId(String rootCommentId, Sort sort);   // ? 
    
    @Query(value = "{'rootComment': null}")  // fields = "{ 'rootComment' : 1 }" ? 
    public List<Comment> findByChapter_ChapterId(String chapterId, Sort sort);   // ? 
    
}

package com.example.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.example.model.Comment;
import com.example.model.ErrorResponse;
import com.example.model.LoginInfo;
import com.example.model.RegisterInfo;
import com.example.model.Manga;
import com.example.model.PostChapter;
import com.example.model.PostComment;
import com.example.model.UpdateComment;
import com.example.model.Chapter;
import com.example.model.User;
import com.example.model.UserException;
import com.example.model.Token;
import com.example.model.Favorite;

import com.example.repo.MangaRepo;
import com.example.repo.ChapterRepo;
import com.example.repo.CommentRepo;
import com.example.repo.UserRepo;
import com.example.repo.FavoriteRepo;
import com.example.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/mangamania")
public class MangaManiaRestController {
	
	

	Logger logger = LoggerFactory.getLogger(MangaManiaRestController.class);
	
	@Autowired private MangaRepo mangaRepo;
	@Autowired private ChapterRepo chapterRepo;
	@Autowired private CommentRepo commentRepo;
	@Autowired private UserRepo userRepo;
	@Autowired private FavoriteRepo favoritesRepo;
	
	@Autowired private UserService userService;
	
	//@SuppressWarnings("null")
	@PostConstruct
	public void init() {
	    try {
	        logger.info("Inside the init() method");
	        
	 /*
	        String mangaId = "6625222636c99ae69dedd9d4"; //6625222636c99ae69dedd9d4
	        Manga manga = mangaRepo.findById(mangaId)
	                .orElseThrow(() -> new RuntimeException("Manga not found"));
	        logger.info("Manga found");

	        Chapter chapter = new Chapter("chapter 1", 1, "chapter 1", manga);
	        logger.info("Creating chapter: " + chapter.toString());

	        chapterRepo.save(chapter);
	        
	 */
	        
	        
	        /*
	        String mangaId = "6625222636c99ae69dedd9d4"; //6625222636c99ae69dedd9d4
	        Manga manga = mangaRepo.findById(mangaId)
	                .orElseThrow(() -> new RuntimeException("Manga not found"));
	        logger.info("Manga found");
	        
	        String chapterId = "66277e0c258441156f0a8ff3";
	        Chapter chapter = chapterRepo.findById(chapterId).orElseThrow(() -> new RuntimeException("Chapter not found"));
	        logger.info("Chapter  found");
	        
	       
	        String userId = "66278bd44c803c10509ff631";
	        User u = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	        logger.info("User  found");
	        
	        String commentId = "";
	        Comment com = commentRepo.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
	        logger.info("Comment found");
	        */
	        
	 /*      
	        List<User> l = new ArrayList<>();
	     
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        
	       
	        Comment c = new Comment(u,"I love One Piece ",currentDateTime,l,l,null,chapter,manga);
	        //Comment comment = new Comment(u, "One piece is great!!", currentDateTime , a,a, null, c, manga);
	        
	        commentRepo.save(c);
	      
	  */      
	        
	        
	        /*
	         * 66251c21fc955d411a84c3af   - dorohedoro 167 chapter 
	         * 66251c21fc955d411a84c3b0   - Shoujo Shuumatsu Ryokou  47 chapter 
	         * 66251c21fc955d411a84c3b1   - ReLIFE  227 chapters
	         * 66251c21fc955d411a84c3b4   - Kingdom 771 chapters 
	         * 66251c21fc955d411a84c3b5   - Sousou no Frieren  124 chapters
	         * 66251c21fc955d411a84c3b7   - Bungou Stray Dogs: Beast 22 chapters
	         * 66251c21fc955d411a84c3b9   - Kozure Ookami  142 chapters
	         * 66251c21fc955d411a84c3ba   - Akira  120 chapters
	         * 66251c21fc955d411a84c3bd   - Slam Dunk 276 chapters
	         * 66251c21fc955d411a84c3be   - Death Note 108 chapters
	         
	         */
	        
	       
	    } catch (Exception e) {
	        logger.error("Exception in init() method", e);
	    }
	}

	// fill this with requests
	
	
	// get all  
	@GetMapping("/manga")  // works
	public List<Manga> manga(){
		return mangaRepo.findAll();
	}
	
	@GetMapping("/chapter")  // works
	public List<Chapter> chapter(){
		return chapterRepo.findAll();
	}
	
	@GetMapping("/comment")  // works
	public List<Comment> comment(){
		return commentRepo.findAll();
	}
	
	@GetMapping("/rootcomment")  // fix this 
	public List<Comment> rootComment(){
		return commentRepo.findDistinctRootComments();
	}
	
	@GetMapping("/rootcomment/")  // fix this 
	public List<Comment> rootComment(@RequestParam String id){
		
	
		Sort sort = Sort.by(Sort.Direction.ASC, "date");

		// Retrieve comments under the specific root comment sorted by date
		List<Comment> commentsUnderRoot = commentRepo.findByRootComment_CommentId(id, sort);
		return commentsUnderRoot;

	}
	
	
	@GetMapping("/user")  // works
	public List<User> user(){
		return userRepo.findAll();
	}
	
	@GetMapping("/favorite")
	public Favorite favorites(@RequestHeader("token") String token){
		User user = userRepo.findByTokenString(token);
		return favoritesRepo.findByUser(user.getUserId());
	}
	
	// find by id, username, usermail 
	
	

	@GetMapping("/manga/")  // works
	public Manga findMangabyId(@RequestParam String id){
		Optional<Manga> mangaById = mangaRepo.findById(id);
		Manga manga = mangaById.orElse(null);
		return manga;
	}
	
	@GetMapping("/chapter/")  // works
	public Chapter findChapterbyId(@RequestParam String id){
		Optional<Chapter> chapterById = chapterRepo.findById(id);
		Chapter chapter = chapterById.orElse(null);
		return chapter;
	}
	
	@GetMapping("/comment/")  // works
	public Comment findCommentbyId(@RequestParam String id){
		Optional<Comment> commentById = commentRepo.findById(id);
		Comment comment = commentById.orElse(null);
		return comment;
	}
	
	@GetMapping("/user/")  // works
	public User findUserbyToken(@RequestHeader("token") String token){
		User user = userRepo.findByTokenString(token);
		return user;
	}
	
	@GetMapping("/usermail/")  // works  
	public User findUserbyMail(@RequestParam String mail){
		Optional<User> userById = userRepo.findByMail(mail);
		User user = userById.orElse(null);
		return user;
	}
	
	@GetMapping("/username/")  // works  
	public User findUserbyUsername(@RequestParam String username){
		Optional<User> userById = userRepo.findByUsername(username);
		User user = userById.orElse(null);
		return user;
	}
	
	
	
	// search by  name
	
	@GetMapping("/manga/search/en/")  // works  
	public List<Manga> searchMangaEn(@RequestParam String titleEn){
		
		List<Manga> mangas = mangaRepo.findByTitleEnContainsIgnoreCase(titleEn);
		return mangas;
	}
	
	
	
	@GetMapping("/manga/search/ov/")  // works  
	public List<Manga> searchMangaOv(@RequestParam String titleOv){
		
		List<Manga> mangas = mangaRepo.findByTitleOvContainsIgnoreCase( titleOv);
		return mangas;
	}
	
	
	@GetMapping("/chapter/search/chapterName/")   // works 
	public List<Chapter> searchChapterName(@RequestParam String name){
		List<Chapter> chapters = chapterRepo.findByChapterNameContainsIgnoreCase(name);
		return chapters;
	}
	
	@GetMapping("/chapter/search/mangaid/")   // works  
	public List<Chapter> searchChapterbyMangaid(@RequestParam String id){
		List<Chapter> chapters = chapterRepo.findByManga_MangaId(id);
		return chapters;
	}
	
	
	@GetMapping("/comment/search/token/")   // works     
	public List<Comment> searchCommentbyUsername(@RequestHeader("token") String token){
		User user = userRepo.findByTokenString(token);
		List<Comment> comments = commentRepo.findByUserCommented_UserId(user.getUserId());
		return comments;
	}

	@GetMapping("/comment/search/chapterid/")   // works     
	public List<Comment> searchCommentbyChapterId(@RequestParam String id){
		List<Comment> comments = commentRepo.findByChapter_ChapterId(id);
		return comments;
	}



	
	// post/ save  a single object 
	

	@PostMapping("/chapter/save")  // works
	public ErrorResponse<String> saveChapter(@RequestBody PostChapter chapterToSave) {
		
		/*  accepts this type as body 
		 {
			  "chapterName": " ",
			  "chapterNumber": 0 ,
			  "description": " ",
			   "mangaId": " "
			}
		 */
		try {
			String chpName = chapterToSave.getChapterName();
			int chpNumber = chapterToSave.getChapterNumber();
			String chpDescription = chapterToSave.getDescription();
			String mangaId = chapterToSave.getMangaId();
			
			Optional<Manga> mangaFound = mangaRepo.findById(mangaId);
			Manga manga = mangaFound.orElse(null);
			
			
			Chapter newChapter = new Chapter(chpName,chpNumber,chpDescription,manga);
			
			Chapter chapterSaved = chapterRepo.save(newChapter);
			
			
		}catch(Exception e) {
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Chapter could not be saved to database");
		}
		
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Chapter saved to database");
		
	}

	@PostMapping("/comment/save")  // works
	public ErrorResponse<String> saveComment(@RequestHeader("token") String token, @RequestBody PostComment commentToSave) {
		
		/*   accepts this type as body 
		 {
		 	"commentText": "" ,
		 	"rootComment": "" ,
		 	"chapterId": "" 
	 
	 	}
		 */
		
		try {
			User user = userRepo.findByTokenString(token); 
			Chapter chapter = chapterRepo.findById(commentToSave.getChapterId()).orElse(null);
			//Manga manga = mangaRepo.findById(commentToSave.getMangaId()).orElse(null);
			
			//Comment rootComment = commentRepo.findById(commentToSave.getRootComment()).orElse(null);
			
			Comment rootComment = null;
		    if (commentToSave.getRootComment() != null && !commentToSave.getRootComment().isEmpty()) {
		        rootComment = commentRepo.findById(commentToSave.getRootComment()).orElse(null);
		    }
					
			String commentText = commentToSave.getCommentText();
			
			List<User> listUsers = new ArrayList<>();
			
			LocalDateTime currentDateTime = LocalDateTime.now();
			
			Comment newComment = new Comment(user,commentText,currentDateTime ,listUsers,listUsers,rootComment,chapter);
			 
			 
			commentRepo.save(newComment);
			
			 
		}catch(Exception e){
			 return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Comment could not be saved to database");
			
		}
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Comment saved to database");
	}
	
	
	
	//   alter object 
	
	@PutMapping("/comment/like/")   // it can add but it keeps adding or does not delete from dislikes
    public ErrorResponse<String> likeComment(@RequestHeader("token") String token, @RequestParam String commentId) {
        try {
        	 Comment comment = commentRepo.findById(commentId).orElse(null); 
             User user = userRepo.findByTokenString(token); 
             String userId = user.getUserId();
             
             List<User> likeActivity = comment.getLikes();
             boolean alreadyExits = false;
             for(User u : likeActivity)
             {
            	if(u.getUserId().equals(user.getUserId())){
            		alreadyExits = true;
            	
            	}
             }
             
             if(!alreadyExits) {likeActivity.add(user);}
             
             
             List<User> dislikeActivity = comment.getDislikes();
             ;
             
             dislikeActivity.removeIf(element -> element.getUserId().equals(userId));
             
             
             comment.setLikes(likeActivity);
             comment.setDislikes(dislikeActivity);
             
             commentRepo.save(comment);
             
        	
        }catch(Exception e) {
        	return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Comment could not be liked");
        }
        
        return new ErrorResponse<String>(LocalDateTime.now(),"OK","Comment liked");
    }
	

	@PutMapping("/comment/dislike/")  // it can add but it keeps adding or does not delete from likes
    public ErrorResponse<String> dislikeComment(@RequestHeader("token") String token, @RequestParam String commentId) {
		try {
			Comment comment = commentRepo.findById(commentId).orElse(null); 
			 User user = userRepo.findByTokenString(token); 
			 String userId = user.getUserId();
			 
			 List<User> dislikeActivity = comment.getDislikes();
             boolean alreadyExits = false;
             for(User u : dislikeActivity)
             {
            	if(u.getUserId().equals(user.getUserId())){
            		alreadyExits = true;
            	}
             }
             
             if(!alreadyExits) {dislikeActivity.add(user);}
             
             
             List<User> likeActivity = comment.getLikes();
             
             likeActivity.removeIf(element -> element.getUserId().equals(userId));
           
             comment.setLikes(likeActivity);
             comment.setDislikes(dislikeActivity);
	        
	        Comment updatedComment = commentRepo.save(comment);
	   
			
		}catch(Exception e) {
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Comment could not be disliked");
			
		}
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Comment disliked");
    }
	
	
	@PutMapping("/comment/alter/")   // works
	public ErrorResponse<String> alterCommentText(@RequestHeader("token") String token,@RequestBody UpdateComment updatedComment ){
		try {
			Comment comment = commentRepo.findById(updatedComment.getCommentId() ).orElse(null);
			User user = userRepo.findByTokenString(token);
			String user_id = user.getUserId();
			
			if(comment.getUserCommented().getUserId().equals(user_id) ) {
				String text = updatedComment.getCommentText();
				comment.setCommentText(text);
				
				Comment updated = commentRepo.save(comment);
				
				return new ErrorResponse<String>(LocalDateTime.now(),"OK","Comment succesfully updated.");
			}
			else {
				return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Comments can only be altered by those who write them ");
			}
			
		} catch(Exception e) {
			
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR",e.getMessage() );
			
		}
	
	}
	
	
	
	@DeleteMapping("/comment/delete/")
	public ErrorResponse<String> deleteComment(@RequestHeader("token") String token, @RequestParam String commentId ){
		try {
			Comment comment = commentRepo.findById(commentId).orElse(null);
			User user = userRepo.findByTokenString(token);
			String user_id = user.getUserId();
			
			if(comment.getUserCommented().getUserId().equals(user_id) ) {  // this is the person that wrote the comment, so they can delete it
				
				if(comment.getRootComment() != null) {  // it means root comment is full,referencing another comment,meaning  it is a leaf 
					commentRepo.delete(comment);
				}
				else {
					Sort sort = Sort.by(Sort.Direction.ASC, "date");
					List<Comment> commentsToUpdate = commentRepo.findByRootComment_CommentId(commentId, sort);
					if(! commentsToUpdate.isEmpty()) {  
						
						
						Comment newRoot = commentsToUpdate.get(0);
						newRoot.setRootComment(null);
						commentRepo.save(newRoot);
						newRoot.toString();
						
						if(commentsToUpdate.size()>1) {
						
							for(int i = 1; i<commentsToUpdate.size();i++) {
								Comment c = commentsToUpdate.get(i);
								c.setRootComment(newRoot);
								c.toString();
								commentRepo.save(c);
								
							}
						}
					}
					commentRepo.delete(comment);
					
				}
				
				
				
				return new ErrorResponse<String>(LocalDateTime.now(),"OK","Comment succesfully deleted.");
			}
			else {
				return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Comments can only be deleted by their users.");
			}
			
		} catch(Exception e) {
			
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR",e.getMessage() );
			
		}
	
	}
	
	
	@PostMapping("/manga/favorite/")
	public ErrorResponse<String> favoriteManga(@RequestHeader("token") String token, @RequestParam String mangaId ){
		try {
			
			User user = userRepo.findByTokenString(token);
			Optional<Manga> mangaById = mangaRepo.findById(mangaId);
			Manga manga = mangaById.orElse(null);
			
			if(manga.equals(null)) {
				throw new Exception("manga with that id does not exists");
			}
			else {
				
				Favorite fav = favoritesRepo.findByUser(user.getUserId());
				if(fav ==null) {
					
				
					List<Manga> favMangas = new ArrayList<>();
					favMangas.add(manga);
					
					Favorite newfav = new Favorite(user,favMangas);
					favoritesRepo.save(newfav);
					
				}
				else {
				
					List<Manga> favMangas = fav.getFavoriteMangas();
		             boolean alreadyExits = false;
		             for(Manga m : favMangas)
		             {
		            	if(m.equals(manga)){
		            		alreadyExits = true;
		            	}
		             }
		             
		             if(!alreadyExits) {favMangas.add(manga);}
					fav.setFavoriteMangas(favMangas);
					
					favoritesRepo.save(fav);
				}
			}
			
		}catch(Exception e) {
			
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Manga could not be favorited");
		}
		
		
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Manga Favorited succesfully");
	}
	
	@PostMapping("/manga/unfavorite/")
	public ErrorResponse<String> unfavoriteManga(@RequestHeader("token") String token, @RequestParam String mangaId ){
		try {
			
			User user = userRepo.findByTokenString(token);
			Optional<Manga> mangaById = mangaRepo.findById(mangaId);
			Manga manga = mangaById.orElse(null);
			
			if(manga.equals(null)) {
				throw new Exception("manga with that id does not exists");
			}
			else {
				Favorite fav = favoritesRepo.findByUser(user.getUserId());
				
				if(fav !=null) {
					
					List<Manga> favMangas = fav.getFavoriteMangas();
		            favMangas.removeIf(element -> element.getMangaId().equals(manga.getMangaId()));
					fav.setFavoriteMangas(favMangas);
					
					favoritesRepo.save(fav);
				}
				else {
					return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","manga needs to be favorited before to be unfavorited");
				}
			}
			
		}catch(Exception e) {
			
			return new ErrorResponse<String>(LocalDateTime.now(),"ERROR","Manga could not be unfavorited");
		}
		
		
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Manga Unfavorited succesfully");
	}
	
	
	/*
	
	delete comments has some issu 
	

	*/
	
	
	@PostMapping("/login")
	public ErrorResponse<Token> loginUser(@RequestBody LoginInfo loginInfo){
		User user;
		try {
			user = userService.loginUser(loginInfo);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		
		return new ErrorResponse<Token>(LocalDateTime.now(),"OK",user.getToken());
		
	}
	
	
	@GetMapping("/logout")
	public ErrorResponse<String> logoutUser(@RequestHeader String token){

		userService.destroyToken(token);
		
		return new ErrorResponse<String>(LocalDateTime.now(),"OK","Token destroyed.");
		
	}
	
	@PostMapping("/register")
	public ErrorResponse<String> registerUser(@RequestBody RegisterInfo registerInfo ) throws UserException{
		
		
		if(registerInfo.getUsername()==null ||  
				registerInfo.getPassword()==null || 
						registerInfo.getMail()==null ){
			logger.error("User field problem");
			throw new UserException("All fields are required.");
		}
		
		try {
			
			Optional<User> userByUsername = userRepo.findByUsernameAndMail(registerInfo.getUsername(), registerInfo.getMail());
			User userCast = userByUsername.orElse(null);
			
			if(userCast == null ) {
				User usertoRegister = new User(registerInfo.getUsername(),registerInfo.getMail(),registerInfo.getPassword());
				userService.registerUser(usertoRegister);
			}
			else{
				userService.registerUser(userCast);
			}
		
		} catch (Exception e) {
			logger.error(e.getMessage());
		
			throw new UserException(e.getMessage());
		}
		
		return new ErrorResponse<String>(LocalDateTime.now(),"OK", "User registered.");
		
		
	}
	
	
	
	
	
	
}

package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	

	@Id private String commentId;
	
	private User userCommented;  // comment cannot exist without a user , composition
	
	private String commentText;
	private LocalDateTime date;
	


	@DBRef
	private List<User> likes;     // list of user id's that liked/ disliked a specific comment
	@DBRef
	private List<User> dislikes;
	
	@DBRef
	private Comment rootComment;   // if it is a reply, there should be a comment id, if not empty
	
	@DBRef
	private Chapter chapter;     // foreign key to chapter

	   // foreign key to manga


	public Comment(User userCommented, String commentText, LocalDateTime date, List<User> likes, List<User> dislikes,
			Comment rootComment, Chapter chapter) {
		super();
		this.userCommented = userCommented;
		this.commentText = commentText;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.rootComment = rootComment;
		this.chapter = chapter;
		
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public User getUserCommented() {
		return userCommented;
	}

	public void setUserCommented(User userCommented) {
		this.userCommented = userCommented;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	

	

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public List<User> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<User> dislikes) {
		this.dislikes = dislikes;
	}

	public Comment getRootComment() {
		return rootComment;
	}

	public void setRootComment(Comment rootComment) {
		this.rootComment = rootComment;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", rootComment=" + rootComment + "]";
	}

	
	

}

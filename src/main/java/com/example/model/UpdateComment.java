package com.example.model;

public class UpdateComment {
	
	
	private String commentId;
	private String commentText;
	
	public UpdateComment(String commentId, String commentText) {
		super();
		
		this.commentId = commentId;
		this.commentText = commentText;
	}

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	
	

}

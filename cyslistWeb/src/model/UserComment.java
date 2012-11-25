package model;

public class UserComment {
	long commentId;
	User user;
	String comment;
	
	public UserComment(){
		
	}
	
	public long getCommentId(){
		return commentId;
	}
	public void setCommentId(long commentId){
		this.commentId = commentId;
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public String getComment(){
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
}

package model;

import java.util.Date;

public class UserPost {
	long postId;
	String content;
	Date date;
	String title;
	
	public UserPost(){
		
	}
	
	public long getPostId(){
		return postId;
	}
	public void setPostId(long postId){
		this.postId = postId;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}

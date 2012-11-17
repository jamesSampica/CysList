package model;

import java.util.Date;

public class UserPost {
	
	long postId;
	String content;
	String topic;
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
	public String getTopic(){
		return topic;
	}
	public void setTopic(String topic){
		this.topic = topic;
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

package com.web.userPost;

import org.apache.struts.upload.FormFile;


public class UserPostForm extends org.apache.struts.action.ActionForm {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8405309615364232978L;
	
	private String content;
	private String topic;
	private String title;
	private String email;
	private FormFile image;
	
	public UserPostForm(){
		super();
	}
	public String getTopic(){
		return topic;
	}
	public void setTopic(String topic){
		this.topic = topic;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public FormFile getImage() {  
		return image;  
	}    
	public void setImage(FormFile image) {  
		this.image = image;  
	}
}

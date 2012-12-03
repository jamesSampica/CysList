package com.web.userPost;

/**
 * 
 * @author James Sampica
 * Defines the user form for the edit/delete action
 */
public class ManagePostForm extends org.apache.struts.action.ActionForm {
	
	String content;
	String topic;
	String title;
	String email;
	
	/**
	 * class constructor
	 */
	public ManagePostForm(){
		super();
	}
	
	/**
	 * 
	 * @return the post topic
	 */
	public String getTopic(){
		return topic;
	}
	
	/**
	 * 
	 * @param topic the post topic
	 */
	public void setTopic(String topic){
		this.topic = topic;
	}
	
	/**
	 * 
	 * @return the post content
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * 
	 * @param content the post content
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 * 
	 * @return the post title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * 
	 * @param title the post title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * 
	 * @return the post email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * 
	 * @param email the post email
	 */
	public void setEmail(String email){
		this.email = email;
	}
}

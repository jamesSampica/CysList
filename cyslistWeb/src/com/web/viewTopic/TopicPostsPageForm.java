package com.web.viewTopic;

/**
 * 
 * @author James Sampica
 * Defines a "hidden" form on the index page that carries the topic information to the topic posts page
 */
public class TopicPostsPageForm extends org.apache.struts.action.ActionForm{
	
	String topic;
	
	/**
	 * class constructor
	 */
	public TopicPostsPageForm(){
		super();
	}
	
	/**
	 * 
	 * @return posts topic
	 */
	public String getTopic(){
		return topic;
	}
	
	/**
	 * 
	 * @param topic posts topic
	 */
	public void setTopic(String topic){
		this.topic = topic;
	}
}

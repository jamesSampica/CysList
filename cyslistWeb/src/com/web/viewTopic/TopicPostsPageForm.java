package com.web.viewTopic;

public class TopicPostsPageForm extends org.apache.struts.action.ActionForm{
	
	String topic;
	
	public TopicPostsPageForm(){
		super();
	}
	
	public String getTopic(){
		return topic;
	}
	
	public void setTopic(String topic){
		this.topic = topic;
	}
}

package com.web.viewTopic;

public class TopicPostsForm extends org.apache.struts.action.ActionForm {
	
	String topic;
	
	public TopicPostsForm(){
		super();
	}
	public String getTopic(){
		return topic;
	}
	public void setTopic(String topic){
		this.topic = topic;
	}
}

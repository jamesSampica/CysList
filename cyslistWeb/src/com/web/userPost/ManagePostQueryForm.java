package com.web.userPost;

public class ManagePostQueryForm extends org.apache.struts.action.ActionForm{
    
	String key;
	
	public ManagePostQueryForm(){
		super();
	}
	public String getKey(){
		return key;
	}
	public void setKey(String key){
		this.key = key;
	}
}

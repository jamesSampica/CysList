package com.web.userPost;

/**
 * 
 * @author James Sampica
 * Defines the form for edit/delete that takes a key to get the correct post to edit/delete
 */
public class ManagePostQueryForm extends org.apache.struts.action.ActionForm{
    
	String key;
	
	/**
	 * class constructor
	 */
	public ManagePostQueryForm(){
		super();
	}
	
	/**
	 * 
	 * @return the post key
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * 
	 * @param key the post key
	 */
	public void setKey(String key){
		this.key = key;
	}
}

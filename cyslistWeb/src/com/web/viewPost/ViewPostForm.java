package com.web.viewPost;

/**
 * 
 * @author James Sampica
 * Defines the "hidden" form that sends the postNum from the topic Posts to the single post page
 */
public class ViewPostForm extends org.apache.struts.action.ActionForm{

	private String postNum;
	
	/**
	 * the class constructor
	 */
	public ViewPostForm(){
		super();
	}
	
	/**
	 * 
	 * @return the 1 indexed post number
	 */
	public String getPostNum(){
		return postNum;
	}
	
	/**
	 * 
	 * @return the 1 indexed post number
	 */
	public void setPostNum(String postNum){
		this.postNum = postNum;
	}
}

package com.web.viewPost;

public class ViewPostForm extends org.apache.struts.action.ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3366651309715940091L;
	String postNum;
	
	public ViewPostForm(){
		super();
	}
	
	public String getPostNum(){
		return postNum;
	}
	public void setPostNum(String postNum){
		this.postNum = postNum;
	}
}

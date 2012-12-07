package com.web.flag;

public class UserFlagForm extends org.apache.struts.action.ActionForm{
	String postKey;
	
	public UserFlagForm()
	{
		super();
	}

	public String getPostKey() {
		return postKey;
	}

	public void setPostKey(String postKey) {
		this.postKey = postKey;
	}

	
}

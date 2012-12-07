package com.web.viewProfile;

public class ViewProfileForm extends org.apache.struts.action.ActionForm{
	String name;
	
	public ViewProfileForm()
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

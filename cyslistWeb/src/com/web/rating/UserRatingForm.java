package com.web.rating;
/**
 * 
 * @author Yifei Zhu
 *	
 *Rating form 
 *
 */
public class UserRatingForm extends org.apache.struts.action.ActionForm{
	int rating;
	String email;
	
	
	public UserRatingForm(){
		super();
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rate) {
		this.rating = rate;
	}
	
	
}

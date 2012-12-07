package com.web.search;

import org.apache.struts.action.ActionForm;

/**
 * Form for searching. Contains information about the search performed.
 * 
 * @author Tony
 * 
 */
public class SearchForm extends ActionForm {

	private static final long serialVersionUID = 2998417018399626897L;

	/**
	 * The value to search for.
	 */
	private String value = "";

	/**
	 * The topic to search in.
	 */
	private String category = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

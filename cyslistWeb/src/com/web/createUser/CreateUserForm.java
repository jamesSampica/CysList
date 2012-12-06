package com.web.createUser;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.EncryptionService;

/**
 * Form information for a create user attempt.
 * 
 * @author Tony
 * 
 */
public class CreateUserForm extends ActionForm {

	private static final long serialVersionUID = -8049016477300699212L;

	private String name;
	private String email;
	private String password;
	private String adminKey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (name == null || name.length() < 1) {
			errors.add("name", new ActionMessage("User Name is required."));
		}
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("Password is required."));
		}
		if (!email.matches(".+@(.+\\.)*iastate\\.edu")) {
			errors.add("email", new ActionMessage(
					"Must provided a valid Iowa State email."));
		}
		return errors;
	}

	/**
	 * Attempts to encrypt the password. If there are errors the password will
	 * not be changed and the errors will be returned.
	 * 
	 * @return A list of errors that occurred.
	 */
	public ActionErrors encryptPassword() {
		String oldPass = password;
		ActionErrors errors = new ActionErrors();
		try {
			password = EncryptionService.getInstance().encrypt(password);
		} catch (NoSuchAlgorithmException e) {
			password = oldPass;
			errors.add("password", new ActionMessage(
					"Error encrypting password."));
		}
		return errors;
	}
}

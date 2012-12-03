package com.web.createUser;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.EncryptionService;

public class CreateUserForm extends ActionForm {

	private static final long serialVersionUID = -8049016477300699212L;

	private String name;
	private String email;
	private String password;

	public CreateUserForm() {
	}

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

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		String oldPass = password;

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

		if (errors.isEmpty()) {
			try {
				password = EncryptionService.getInstance().encrypt(password);
			} catch (NoSuchAlgorithmException e) {
				password = oldPass;
				errors.add("password", new ActionMessage(
						"Error encrypting password."));
			}
		}
		return errors;
	}
}

package com.web.login;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.EncryptionService;
import util.HibernateUtil;

/**
 * Attempts to log in a user.
 * 
 * @author Tony
 * 
 */
public class LoginAction extends org.apache.struts.action.Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;
		ActionErrors errors = loginForm.validate(mapping, request);
		HttpSession session = request.getSession();

		// If there were validation errors, add them to the session and return
		// failure.
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			return mapping.findForward("failure");
		}

		// Get the user.
		User user = HibernateUtil.findUserByName(loginForm.getUserName());

		// If the user is null, the account doesn't exist.
		if (user == null) {
			errors.add("userName", new ActionMessage("Account doesn't exist."));
			request.setAttribute("errors", errors);
			return mapping.findForward("failure");
		}

		// Check password
		try {
			if (user.getPassword().equals(
					EncryptionService.getInstance().encrypt(
							loginForm.getPassword()))) {
				// Correct password
				session.setAttribute("active_user", user);
				return mapping.findForward("success");
			}
		} catch (NoSuchAlgorithmException e) {
		}

		errors.add("password", new ActionMessage("Wrong password."));
		request.setAttribute("errors", errors);
		return mapping.findForward("failure");
	}
}
package com.web.createUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.HibernateUtil;

/**
 * Attempts to create a new user.
 * 
 * @author Tony
 * 
 */
public class CreateUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Cast form.
		CreateUserForm uForm = (CreateUserForm) form;
		String oldPass = uForm.getPassword();

		// Validate the form (make sure password, name, and email are there).
		ActionErrors errors = uForm.validate(mapping,
				(HttpServletRequest) request);
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			return mapping.findForward("failure");
		}

		// Encrypt the password.
		errors = uForm.encryptPassword();
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			return mapping.findForward("failure");
		}

		// Attempt to save it.
		if (HibernateUtil.createAndStoreUser(uForm.getName(), uForm.getEmail(),
				uForm.getPassword(), uForm.getAdminKey())) {
			request.setAttribute("name", uForm.getName());
			request.setAttribute("email", uForm.getEmail());

			return mapping.findForward("success");
		}

		// Couldn't save because an account exists with the name, so
		// reset the password.
		uForm.setPassword(oldPass);
		errors.add("name", new ActionMessage(
				"Account with that name already exists."));
		request.setAttribute("errors", errors);
		return mapping.findForward("failure");
	}

}

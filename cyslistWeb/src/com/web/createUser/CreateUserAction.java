package com.web.createUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.HibernateUtil;

public class CreateUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Cast form.
		CreateUserForm uForm = (CreateUserForm) form;

		ActionErrors errors = uForm.validate(mapping,
				(HttpServletRequest) request);
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			return mapping.findForward("failure");
		}
		request.setAttribute("name", uForm.getName());
		request.setAttribute("email", uForm.getEmail());
		return mapping.findForward(HibernateUtil.createAndStoreUser(
				uForm.getName(), uForm.getEmail(), uForm.getPassword()));
	}

}

package com.web.deleteUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import util.HibernateUtil;
import util.Resources;

public class DeleteUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DeleteUserForm dForm = (DeleteUserForm) form;
		User user = (User) request.getSession().getAttribute(
				Resources.ACTIVE_USER);
		ActionErrors errors = new ActionErrors();

		if (user == null) {
			errors.add("userName", new ActionMessage("You are not a user..."));
			request.setAttribute("errors", errors);
			return mapping.findForward(Resources.FAILURE);
		}

		if (dForm.getUserName().equals(user.getName())) {
			errors.add("userName", new ActionMessage("Cannot delete yourself."));
			request.setAttribute("errors", errors);
			return mapping.findForward(Resources.FAILURE);
		}

		if (!user.getIsAdmin()) {
			errors.add("userName", new ActionMessage("You are not an admin..."));
			request.setAttribute("errors", errors);
			return mapping.findForward(Resources.FAILURE);
		}

		User temp = HibernateUtil.findUserByName(dForm.getUserName());
		if (temp == null) {
			errors.add("userName", new ActionMessage("User doesn't exist."));
			request.setAttribute("errors", errors);
			return mapping.findForward(Resources.FAILURE);
		}

		HibernateUtil.deleteUser(temp);

		// TODO Auto-generated method stub
		return mapping.findForward(Resources.SUCCESS);
	}
}

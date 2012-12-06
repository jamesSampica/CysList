package com.web.deleteUser;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.HibernateUtil;

/**
 * Deletes accounts from the database.
 * 
 * @author Tony
 * 
 */
public class CommittDeleteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Sets up some variables that will be needed.
		DeleteUserForm dForm = (DeleteUserForm) form;
		User self = (User) request.getSession().getAttribute("active_user");
		boolean deleteSelf = false;

		List<UserInfo> userList = dForm.getUserList();
		List<User> toDel = new ArrayList<User>();

		// Go through each UserInfo and determine which will be deleted. If the
		// logged in user has opted to delete his/her own account make note of
		// that.
		for (UserInfo i : userList) {
			if (i.getDelete()) {
				toDel.add(i.getUser());
				if (self != null && self.getUserId() == i.getUser().getUserId())
					deleteSelf = true;
			}
		}

		HibernateUtil.deleteUser(toDel);

		// If the logged in user no longer exists, clear session and return to
		// index.
		if (deleteSelf) {
			request.getSession().removeAttribute("active_user");
			return mapping.findForward("deleteself");
		}

		// Return success.
		return mapping.findForward("success");
	}
}

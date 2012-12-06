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
 * Action to populate the list of Users in deleteusers.jsp.
 * 
 * @author Tony
 * 
 */
public class UserListAction extends Action {

	public UserListAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeleteUserForm dForm = (DeleteUserForm) form;

		// Get the current user and setup some variables.
		User cur = (User) request.getSession().getAttribute("active_user");
		List<User> users = new ArrayList<User>();
		List<UserInfo> userList = new ArrayList<UserInfo>();

		// If there is no loged in user, return failure. Otherwise if the user
		// is not an admin only list the logged in account or if the user is and
		// admin list all accounts.
		if (cur == null)
			return mapping.findForward("failure");
		else if (!cur.getIsAdmin()) {
			users.add(HibernateUtil.findUserByName(cur.getName()));
		} else {
			users = HibernateUtil.getAllUsers();
		}

		// Create UserInfo objects for each User.
		for (User u : users) {
			userList.add(new UserInfo(u, false));
		}

		// save the list of users in our form.
		dForm.setUserList(userList);

		return mapping.findForward("success");
	}
}

package com.web.deleteUser;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

/**
 * Stores a list of UserInfo. This form is used with UserListAction and
 * CommittDeleteAction to display a set of accounts to the logged in user and
 * allowed the deletion of those accounts.
 * 
 * @author Tony
 * 
 */
public class DeleteUserForm extends ActionForm {

	private static final long serialVersionUID = 4244242851907055822L;

	/**
	 * The list of UserInfo that will be displayed.
	 */
	private List<UserInfo> userList;

	/**
	 * Basic constructor, nothing special.
	 */
	public DeleteUserForm() {
		super();
		userList = new ArrayList<UserInfo>();
	}

	/**
	 * Sets the list of users.
	 * 
	 * @param list
	 *            The list of UserInfo.
	 */
	public void setUserList(List<UserInfo> list) {
		userList = list;
	}

	/**
	 * Gets the list of UserInfo.
	 * 
	 * @return A list of UserInfo.
	 */
	public List<UserInfo> getUserList() {
		return this.userList;
	}

	/**
	 * Gets the UserInfo and the given index.
	 * 
	 * @param index
	 *            The index of the UserInfo to return.
	 * @return A UserInfo object.
	 */
	public UserInfo getUserInfo(int index) {
		if (this.userList == null) {
			this.userList = new ArrayList<UserInfo>();
		}

		// Indexes don't come in order.
		while (index >= this.userList.size()) {
			this.userList.add(new UserInfo());
		}

		return userList.get(index);
	}

}

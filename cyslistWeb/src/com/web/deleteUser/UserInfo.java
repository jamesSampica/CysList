package com.web.deleteUser;

import model.User;

/**
 * A wrapper class for User. Adds variables for deleting a user.
 * 
 * @author Tony
 * 
 */
public class UserInfo {

	/**
	 * The user.
	 */
	private User user;

	/**
	 * Whether the user should be deleted or not.
	 */
	private boolean delete;

	/**
	 * Creates a new UserInfo that will initially not be deleted. The user is am
	 * empty User.
	 */
	public UserInfo() {
		user = new User();
		delete = false;
	}

	/**
	 * Creates a UserInfo with the given information.
	 * 
	 * @param u
	 *            The user.
	 * @param delete
	 *            Whether the user should be deleted or not.
	 */
	public UserInfo(User u, boolean delete) {
		this.user = u;
		this.delete = delete;
	}

	/**
	 * Gets the user being held in this object.
	 * 
	 * @return The user.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user to hold in this object.
	 * 
	 * @param u
	 *            The user.
	 */
	public void setUser(User u) {
		this.user = u;
	}

	/**
	 * Gets whether the user being held should be deleted.
	 * 
	 * @return Whether the user being held will be deleted.
	 */
	public boolean getDelete() {
		return delete;
	}

	/**
	 * Sets whether the user being held should be deleted.
	 * 
	 * @param delete
	 *            True to delete the user, false otherwise.
	 */
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}

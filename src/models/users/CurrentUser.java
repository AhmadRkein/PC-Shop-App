package models.users;

public class CurrentUser {

	private static User userInstance;

	private CurrentUser() {
	}

	public static User getUser() {
		return userInstance;
	}

	public static void setUser(User user) {
		userInstance = user;
	}

}


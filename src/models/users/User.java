package models.users;

public abstract class User {
	protected String username;
	protected String name;
	protected String password;	
	protected char gender;
	
	public User(String username, String name, char gender, String pass) {
		this.username = username;
		this.name = name;
		this.password = pass;
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	

	public String getName() {
		return name;
	}

	public String getPass() {
		return password;
	}

	public char getGender() {
		return gender;
	}


	public abstract UserType getUserType();
	public abstract boolean isAdmin();
}

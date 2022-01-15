package models.users;

public class Employee extends User {
	private boolean isadmin;
	
	public Employee(String username, String name, char gender, String pass) {
		super(username, name, gender, pass);
		isadmin = false;
	}
	
	public Employee(String username, String name, char gender, String pass, boolean isadmin) {
		super(username, name, gender, pass);
		this.isadmin = isadmin;
	}


	@Override
	public UserType getUserType() {
		return UserType.EMPLOYEE;
	}
	
	@Override
	public boolean isAdmin() {
		return isadmin;
	}

}

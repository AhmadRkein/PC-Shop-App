package models.users;

public class Employee extends User{
	private Boolean isadmin;
	
	public Employee(String un, String pw, String fn,String ln) {
		super(un, pw, fn, ln);
		isadmin = false;
	}
	
	public Employee(String un, String pw, String fn,String ln, Boolean isAdmin) {
		super(un, pw, fn, ln);
		isadmin = isAdmin;
	}

	@Override
	public Boolean isAdmin() {
		// TODO Auto-generated method stub
		return isadmin;
	}
	
	

}

package models.users;

public abstract class User {

	private String username;
	private String password;
	private String FirstName;
	private String LastName;	
	
	public User(String un, String pw, String FN, String LN) {
		username = un;
		password = pw;
		FirstName = FN;
		LastName = LN;
	}
	

	public  String getusername() {
		return username;
		
	}
	public  String getFirstName() {
		return FirstName;

	}
	public  String getLastName() {
		return LastName;
	}

	public  String getpassword() {
		return password;
		
	}

	public  String getname() {
		return FirstName + " " + LastName;
		
	}
	
	public abstract Boolean isAdmin();


	
	
}
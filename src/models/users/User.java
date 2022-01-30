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

	public  String getpassword() {
		return password;
		
	}

	public  String getname() {
		return FirstName + " " + LastName;
		
	}
	
	public abstract Boolean isAdmin();
	
	private void Setpassword(String pw) {
		password = pw;
	}
	
	private void Setname(String fn, String ln) {
		FirstName = fn;
		LastName = ln;
		
	}
	
	public void EditInfo(String username,String password, String FN,String LN) {
		Setpassword(password);
		Setname(FN, LN);
		
	}
	
	
}
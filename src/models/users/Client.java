package models.users;

public class Client extends User {
	public Client(String un, String pw, String fn,String ln) {
		super(un, pw, fn,ln);
	}
	
	
	public void BuyProduct() {
		
	}


	@Override
	public Boolean isAdmin() {
		return false;
	}

}
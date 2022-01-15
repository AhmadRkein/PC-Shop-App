package models.users;

import models.Cart;

public class Client extends User {

	protected Cart _cart;
	
	public Client(String username, String name, char gender, String pass) {
		super(username, name, gender, pass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserType getUserType() {
		// TODO Auto-generated method stub
		return UserType.CLIENT;
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

}

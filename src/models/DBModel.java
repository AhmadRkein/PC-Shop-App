package models;


public class DBModel {
	private static DBModel _instance;
	
	public static DBModel getInstance() {
		if(_instance == null){
			_instance = new DBModel();
		}
		return _instance;
	}
	
	private DBModel() {
		
		
	}
	
}

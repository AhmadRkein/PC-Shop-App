package models;

public class HardDisk extends Product {
	private int Storage;
	
	public int getStorage() {
		return Storage;
	}
	public void setStorage(int storage) {
		Storage = storage;
	}
	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: HardDisk"
				+ "\nCapacity: " + getStorage() + "GB"
				+ "\nPrice: " + getPrice() + "$";
	}
}

package models;

public class Ram extends Product {
	private int Size;
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: RAM"
				+ "\nClock Capacity: " + getSize() + "GB"
				+ "\nPrice: " + getPrice() + "$";
	}
}

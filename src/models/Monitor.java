package models;

public class Monitor extends Product {
	private int Size;
	private String Resolution;
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public String getResolution() {
		return Resolution;
	}
	public void setResolution(String resolution) {
		Resolution = resolution;
	}
	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: Monitor"
				+ "\nSize: " + getSize() + "inches"
				+ "\nResolution: " + getResolution()
				+ "\nPrice: " + getPrice() + "$";
	}
	
}

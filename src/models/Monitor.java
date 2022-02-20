package models;

public class Monitor extends Product {
	private int Size;
	private int Resolution;
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public int getResolution() {
		return Resolution;
	}
	public void setResolution(int resolution) {
		Resolution = resolution;
	}
	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: Monitor"
				+ "\nSize: " + getSize()
				+ "\nResolution: " + getResolution()
				+ "\nPrice: " + getPrice() + "$";
	}
	
}

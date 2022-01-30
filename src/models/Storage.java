package models;

public class Storage extends Product {
	private int Capacity;
	private boolean isHdd;
	
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public boolean isHdd() {
		return isHdd;
	}
	public void setHdd(boolean isHdd) {
		this.isHdd = isHdd;
	}
}

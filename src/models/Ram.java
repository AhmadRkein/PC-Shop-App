package models;

public class Ram extends Product {
	private int Size;
	private boolean isDram;
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public boolean isDram() {
		return isDram;
	}
	public void setDram(boolean isDram) {
		this.isDram = isDram;
	}
	
}

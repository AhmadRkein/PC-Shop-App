package models;

public class GPU extends Product {
	private int ClockSpeed;
	private int VramSize;
	private String BusType;
	
	public int getClockSpeed() {
		return ClockSpeed;
	}
	public void setClockSpeed(int clockSpeed) {
		ClockSpeed = clockSpeed;
	}
	public int getVramSize() {
		return VramSize;
	}
	public void setVramSize(int vramSize) {
		VramSize = vramSize;
	}
	public String getBusType() {
		return BusType;
	}
	public void setBusType(String busType) {
		BusType = busType;
	}
	@Override
	public String getDescription() {
		return "Brand: " + getBrand()
				+ "\nName: " + getName()
				+ "\nType: GPU"
				+ "\nClock Speed: " + getClockSpeed() + "GHz"
				+ "\nVram Capacity: " + getVramSize() + "GB"
				+ "\nBus Type:" + getBusType()
				+ "\nPrice: " + getPrice() + "$";
	}
}

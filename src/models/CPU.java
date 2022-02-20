package models;

public class CPU extends Product {
	private int CoresNb;
	private int Freq;
	private int Speed;
	public int getCoresNb() {
		return CoresNb;
	}
	public void setCoresNb(int coresNb) {
		CoresNb = coresNb;
	}
	public int getFreq() {
		return Freq;
	}
	public void setFreq(int freq) {
		Freq = freq;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}

	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: CPU"
				+ "\nClock Speed: " + getSpeed()
				+ "\nNumber of Cores: " + getCoresNb()
				+ "\nPrice: " + getPrice() + "$";
	}
}

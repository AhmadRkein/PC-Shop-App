package models;

public class CPU extends Product {
	private int CoresNb;
	private float Freq;
	public int getCoresNb() {
		return CoresNb;
	}
	public void setCoresNb(int coresNb) {
		CoresNb = coresNb;
	}
	public float getFreq() {
		return Freq;
	}
	public void setFreq(float freq) {
		Freq = freq;
	}

	@Override
	public String getDescription() {
		return 	  "Brand: "+getBrand()
				+ "\nName: "+getName()
				+ "\nType: CPU"
				+ "\nClock Speed: " + getFreq() + "GHz"
				+ "\nNumber of Cores: " + getCoresNb()
				+ "\nPrice: " + getPrice() + "$";
	}
}

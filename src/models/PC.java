package models;

public class PC extends Product {

	private CPU cpu;
	private GPU gpu;
	private Ram ram;
	private HardDisk storage;
	private Monitor monitor;
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public GPU getGpu() {
		return gpu;
	}
	public void setGpu(GPU gpu) {
		this.gpu = gpu;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public HardDisk getStorage() {
		return storage;
	}
	public void setStorage(HardDisk storage) {
		this.storage = storage;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public String getDescription() {
		return 	  "\nName: "+getName()
				+ "\nType: PC"
				+ "\nComponents:"
				+ "\n\t- " + getCpu().getDescription()
				+ "\n\t- " + getGpu().getDescription()
				+ "\n\t- " + getRam().getDescription()
				+ "\n\t- " + getStorage().getDescription()
				+ "\n\t- " + getMonitor().getDescription()
				+ "\nPrice: " + getPrice();
	}
}

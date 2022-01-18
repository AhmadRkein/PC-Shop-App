package models;

public class PC extends Product {
	public CPU cpu;
	public GPU gpu;
	public Ram ram;
	public HardDisk storage;
	public Monitor monitor;
	
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
	
	
}

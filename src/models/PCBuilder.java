package models;

public interface PCBuilder {
	
	public void BuildCPU();
	public void BuildGPU();
	public void BuildRam();
	public void BuildStorage();
	public void BuildMonitor();
	public PC getPC();
}

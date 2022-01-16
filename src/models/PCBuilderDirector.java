package models;

public class PCBuilderDirector {
	private PCBuilder builder;
	
	public PCBuilderDirector(PCBuilder b) {
		builder = b;
	}
	
	public PC getPC() {
		return this.builder.getPC();
	}
	
	public void constructPC() {
		builder.BuildCPU();
		builder.BuildGPU();
		builder.BuildMonitor();
		builder.BuildRam();
		builder.BuildStorage();
	}
}

package models;

public class BudgetPCBuilder implements PCBuilder {
	private PC _pc;
	private int CPUID = 2;
	private int GPUID = 2;
	private int RAMID = 2;
	private int StorageID = 2;
	private int MonitorID = 2;
	
	
	public BudgetPCBuilder() {
		_pc = new PC();
	}
	
	@Override
	public void BuildCPU() {
		CPU cpu = (CPU)ProductFlyWeight.getProductById(CPUID,ProductType.CPU);
		_pc.setCpu(cpu);

	}

	@Override
	public void BuildGPU() {
		GPU gpu = (GPU)ProductFlyWeight.getProductById(GPUID,ProductType.GPU);
		_pc.setGpu(gpu);
	}

	@Override
	public void BuildRam() {
		Ram ram = (Ram)ProductFlyWeight.getProductById(RAMID,ProductType.RAM);
		_pc.setRam(ram);
	}

	@Override
	public void BuildStorage() {
		HardDisk storage = (HardDisk)ProductFlyWeight.getProductById(StorageID,ProductType.HARDDISK);
		_pc.setStorage(storage);
	}

	@Override
	public void BuildMonitor() {
		Monitor monitor = (Monitor)ProductFlyWeight.getProductById(MonitorID,ProductType.MONITOR);
		_pc.setMonitor(monitor);
	}

	@Override
	public PC getPC() {
		return _pc;
	}

}

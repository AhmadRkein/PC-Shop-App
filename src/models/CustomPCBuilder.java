package models;

public class CustomPCBuilder   {
    private PC _pc;

    public PC BuildPc(CPU cpu, GPU gpu , Ram ram, HardDisk hardDisk, Monitor monitor){
        this._pc = new PC();
        _pc.setCpu(cpu);
        _pc.setGpu(gpu);
        _pc.setRam(ram);
        _pc.setMonitor(monitor);
        _pc.setStorage(hardDisk);
        return _pc;
    }

}

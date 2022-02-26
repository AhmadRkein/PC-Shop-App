package models;

import java.util.HashMap;

public class ProductFlyWeight {
	public static final HashMap<Integer, Product> CPUMap = new HashMap<Integer, Product>();
	public static final HashMap<Integer, Product> GPUMap = new HashMap<Integer, Product>();
	public static final HashMap<Integer, Product> RAMMap = new HashMap<Integer, Product>();
	public static final HashMap<Integer, Product> STORAGEMap = new HashMap<Integer, Product>();
	public static final HashMap<Integer, Product> MONITORMap = new HashMap<Integer, Product>();
	public static final HashMap<Integer, Product> PCMap = new HashMap<Integer, Product>();
	
	
	public static Product getProductById(int pid, ProductType t) {
		Product p = null;
		
		switch (t) {
		case CPU:
			p = CPUMap.get(pid);
			break;
		case GPU:
			p = GPUMap.get(pid);
			break;
		case RAM:
			p = RAMMap.get(pid);
			break;
		case HARDDISK:
			p = STORAGEMap.get(pid);
			break;
		case MONITOR:
			p = MONITORMap.get(pid);
			break;
		case PC:
			p = PCMap.get(pid);
			break;
		}
		
		if (p == null) {
			p = DBModel.getInstance().getProductById(t.name(), pid);
			
			switch (t) {
			case CPU:
				CPUMap.put(pid, p);
				break;
			case GPU:
				GPUMap.put(pid, p);
				break;
			case RAM:
				RAMMap.put(pid, p);
				break;
			case HARDDISK:
				STORAGEMap.put(pid, p);
				break;
			case MONITOR:
				MONITORMap.put(pid, p);
				break;
			case PC:
				PCMap.put(pid, p);
				break;
			}
		}
		return p;
	}
}

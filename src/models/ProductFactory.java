package models;

public class ProductFactory {
	public Product GenerateProduct(String ProductType) {
		if(ProductType == null) {
			return null;
		}
		if(ProductType.equalsIgnoreCase("RAM")) {
			return new Ram();
		}
		if(ProductType.equalsIgnoreCase("HARDDISK")) {
			return new HardDisk();
		}
		if(ProductType.equalsIgnoreCase("CPU")) {
			return new CPU();
		}
		if(ProductType.equalsIgnoreCase("GPU")) {
			return new GPU();
		}
		if(ProductType.equalsIgnoreCase("MONITOR")) {
			return new Monitor();
		}
		
		if(ProductType.equalsIgnoreCase("PC")) {
			return new PC();
		}
		return null;
	}

}

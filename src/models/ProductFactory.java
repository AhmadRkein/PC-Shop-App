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
			return new Ram();
		}
		if(ProductType.equalsIgnoreCase("CPU")) {
			return new Ram();
		}
		if(ProductType.equalsIgnoreCase("GPU")) {
			return new Ram();
		}
		if(ProductType.equalsIgnoreCase("MONITOR")) {
			return new Ram();
		}
		
		if(ProductType.equalsIgnoreCase("GPU")) {
			return new PC();
		}
		return null;
	}

}

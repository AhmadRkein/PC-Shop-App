package models;


import javafx.scene.image.Image;

public class ProductFactory {
	private static final Image IMAGE_CPU = new Image(
			ProductFactory.class.getResource("../resources/images/cpu.png").toString());
	private static final Image IMAGE_GPU = new Image(
			ProductFactory.class.getResource("../resources/images/vga.png").toString());;
	private static final Image IMAGE_HDD = new Image(
			ProductFactory.class.getResource("../resources/images/hdd.png").toString());;
	private static final Image IMAGE_MONITOR = new Image(
			ProductFactory.class.getResource("../resources/images/monitor.png").toString());
	private static final Image IMAGE_RAM = new Image(
			ProductFactory.class.getResource("../resources/images/ram.png").toString());
	private static final Image IMAGE_PC = new Image(
			ProductFactory.class.getResource("../resources/images/pc.png").toString());

	
	public Product GenerateProduct(String ProductType) {
		Product p = null;
		if(ProductType == null) {
			return p;
		}
		else if(ProductType.equalsIgnoreCase("RAM")) {
			p = new Ram();
			p.setImage(IMAGE_RAM);
		}
		else if(ProductType.equalsIgnoreCase("HARDDISK")) {
			p = new HardDisk();
			p.setImage(IMAGE_HDD);
		}
		else if(ProductType.equalsIgnoreCase("CPU")) {
			p = new CPU();
			p.setImage(IMAGE_CPU);
		}
		else if(ProductType.equalsIgnoreCase("GPU")) {
			p = new GPU();
			p.setImage(IMAGE_GPU);
		}
		else if(ProductType.equalsIgnoreCase("MONITOR")) {
			p = new Monitor();
			p.setImage(IMAGE_MONITOR);
		}
		else if(ProductType.equalsIgnoreCase("PC")) {
			p = new PC();
			p.setImage(IMAGE_PC);
		}
		return p;
	}

}

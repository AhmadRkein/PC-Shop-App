package models;

public abstract class Product {
		private int id;
		private String Name;
		private String ProductType;
		private String Brand;
		private float price;
		private String imagePath;
		
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getProductType() {
			return ProductType;
		}
		public void setProductType(String productType) {
			ProductType = productType;
		}
		public String getBrand() {
			return Brand;
		}
		public void setBrand(String brand) {
			Brand = brand;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		
}

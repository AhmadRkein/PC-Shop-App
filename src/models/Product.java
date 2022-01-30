package models;

public abstract class Product {
		private int Id;
		private String Name;
		private String ProductType;
		private String Brand;
		private float Price;
		private String ImagePath;
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
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
			return Price;
		}
		public void setPrice(float price) {
			Price = price;
		}
		public String getImagePath() {
			return ImagePath;
		}
		public void setImagePath(String imagePath) {
			ImagePath = imagePath;
		}
		
		
}

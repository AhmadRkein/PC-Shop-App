package models;
import javafx.scene.image.Image;

public abstract class Product {
		private int Id;
		private String Name;
		private String Brand;
		private float Price;
		private Image image;

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
		public Image getImage() {
			return image;
		}
		public void setImage(Image im) {
			image = im;
		}
		public String toString(){
			return this.getName() + "\t" + this.getPrice() + "$";
		}
		public abstract String getDescription();

}

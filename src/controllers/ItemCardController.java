package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Product;

public class ItemCardController {

    @FXML
    private Label ItemName;

    @FXML
    private Label ItemPrice;

    @FXML
    private ImageView image;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @FXML
    public void initialize(){
        ItemName.setText(product.getName());
        ItemPrice.setText(product.getPrice() + "$");
        image.setImage(product.getImage());
    }
}

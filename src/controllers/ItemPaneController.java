package controllers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Product;

public class ItemPaneController {

    @FXML
    private Label ItemName;

    @FXML
    private Label ItemPrice;

    @FXML
    private ImageView image;

    private Product product;
    private BrowseShopController browseShop;

    public BrowseShopController getBrowseShop() {
        return browseShop;
    }

    public void setBrowseShop(BrowseShopController browseShop) {
        this.browseShop = browseShop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        ItemName.setText(product.getName());
        ItemPrice.setText(product.getPrice() + "$");
        image.setImage(product.getImage());
    }

    @FXML
    public void initialize(){
    }

    @FXML
    void ViewInfo_Click(ActionEvent event) {
        if(browseShop != null)
            browseShop.ViewInfo(product);
    }
}

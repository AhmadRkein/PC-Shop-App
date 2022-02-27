package controllers;

import com.sun.javafx.FXPermissions;
import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.users.CurrentUser;
import models.users.Employee;
import models.users.User;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private StackPane MainPane;

    @FXML
    private Label nameLabel;


    @FXML
    private Button add_btn;

    @FXML
    private AnchorPane content;

    @FXML
    public void initialize() throws IOException {
        content.getChildren().clear();
        User user= CurrentUser.getUser();
        nameLabel.setText(user.getname());
        Parent browseShop;
        browseShop = FXMLLoader.load(getClass().getResource("../resources/views/BrowseShop.fxml"));
        content.getChildren().add(browseShop);
        add_btn.setManaged(false);
        if(user instanceof Employee) {
            add_btn.setManaged(true);
        }
    }
    @FXML
    void LogOutBtn_click(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../resources/views/LoginMenuView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MainMenuBtn_click(ActionEvent event) throws IOException {
        Parent browseShop;
        browseShop = FXMLLoader.load(getClass().getResource("../resources/views/BrowseShop.fxml"));
        content.getChildren().clear();
        content.getChildren().add(browseShop);
    }

    @FXML
    void PCBuilderBtn_click(ActionEvent event) throws IOException  {
        Parent PCBuilder;
        PCBuilder = FXMLLoader.load(getClass().getResource("../resources/views/PcBuilder.fxml"));
        content.getChildren().clear();
        content.getChildren().add(PCBuilder);
    }

    @FXML
    void goto_add_product(ActionEvent event) throws IOException {
        Parent addProduct;
        addProduct = FXMLLoader.load(getClass().getResource("../resources/views/addProduct.fxml"));
        content.getChildren().clear();
        content.getChildren().add(addProduct);
    }

    @FXML
    void SettingsBtn_click(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/views/Settings.fxml"));
        Parent settings = fxmlLoader.load();
        SettingsController controller = fxmlLoader.getController();
        controller.setNameLabel(nameLabel);
        content.getChildren().clear();
        content.getChildren().add(settings);
    }

}

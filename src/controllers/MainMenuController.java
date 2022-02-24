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
import models.users.User;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private StackPane MainPane;

    @FXML
    private Label nameLabel;

    @FXML
    private AnchorPane content;

    @FXML
    public void initialize() throws IOException {
        User user= CurrentUser.getUser();
        nameLabel.setText(user.getname());
        Parent browseShop;
        browseShop = FXMLLoader.load(getClass().getResource("../resources/views/BrowseShop.fxml"));
        content.getChildren().add(browseShop);
    }
    @FXML
    void LogOutBtn_click(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;



    }

    @FXML
    void MainMenuBtn_click(ActionEvent event) throws IOException {
        Parent browseShop;
        browseShop = FXMLLoader.load(getClass().getResource("../resources/views/BrowseShop.fxml"));
        content.getChildren().add(browseShop);
    }

    @FXML
    void PCBuilderBtn_click(ActionEvent event) throws IOException  {
        Parent PCBuilder;
        PCBuilder = FXMLLoader.load(getClass().getResource("../resources/views/PcBuilder.fxml"));
        content.getChildren().add(PCBuilder);
    }

    @FXML
    void SettingsBtn_click(ActionEvent event) {

    }

}

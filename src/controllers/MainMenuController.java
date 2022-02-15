package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.users.CurrentUser;
import models.users.User;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private StackPane MainPane;

    @FXML
    private Label usernameLabel;

    @FXML
    public void initialize(){
        User user= CurrentUser.getUser();
        usernameLabel.setText(user.getname());
    }
    @FXML
    void LogOutBtn_click(ActionEvent event) throws IOException {
        User user= CurrentUser.getUser();
        usernameLabel.setText(user.getname());
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
    void MainMenuBtn_click(ActionEvent event) {

    }

    @FXML
    void PCBuilderBtn_click(ActionEvent event) {

    }

    @FXML
    void SettingsBtn_click(ActionEvent event) {

    }

}
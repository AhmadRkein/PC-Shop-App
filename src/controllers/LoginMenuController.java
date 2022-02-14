package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class LoginMenuController {

    @FXML
    private VBox LoginPane;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private TextField RegFirstNameText;

    @FXML
    private TextField RegLastNameText;

    @FXML
    private PasswordField RegPasswordText;

    @FXML
    private PasswordField RegRepPasswordText;

    @FXML
    private TextField RegUserNameText;

    @FXML
    private VBox RegisterPane;

    @FXML
    private TextField UserNameText;

    @FXML
    public void initialize(){
        LoginPane.toFront();
    }

    @FXML
    void BackBtn_click(MouseEvent event) {

    }

    @FXML
    void GotoRegisterBtn_click(ActionEvent event) {

    }

    @FXML
    void RegisterBtn_click(ActionEvent event) {

    }

    @FXML
    void SignInBtn_click(ActionEvent event) {

    }

}

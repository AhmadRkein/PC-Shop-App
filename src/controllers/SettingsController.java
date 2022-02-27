package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.DBModel;
import models.users.CurrentUser;
import models.users.User;

public class SettingsController {
    @FXML
    public TextField FirstNameID ;
    @FXML
    public TextField LastNameID ;
    @FXML
    public TextField PasswordID ;
    @FXML
    public void initialize() {


    }

    @FXML
    public void SaveInfo(ActionEvent e){
        User u = CurrentUser.getUser() ;
        String FirstName = FirstNameID.getText();
        String LastName = LastNameID.getText();
        String Password = PasswordID.getText();
        u.EditInfo(String.valueOf(this), FirstName, LastName, Password);
    }
}

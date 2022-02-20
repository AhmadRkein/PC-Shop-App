package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.DBModel;
import models.users.Client;
import models.users.CurrentUser;
import models.users.User;

import java.io.IOException;

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
    private Button RegisterBtn;

    @FXML
    private Button SignInBtn;

    @FXML
    public void initialize(){
        LoginPane.toFront();
        RegUserNameText.setText("");
        RegPasswordText.setText("");
        RegRepPasswordText.setText("");
        RegLastNameText.setText("");
        RegFirstNameText.setText("");
        UserNameText.setText("");
        PasswordText.setText("");
        RegisterBtn.defaultButtonProperty().bind(SignInBtn.defaultButtonProperty().not());
        SignInBtn.setDefaultButton(true);
    }

    @FXML
    void BackBtn_click(MouseEvent event) {
        LoginPane.toFront();
        RegUserNameText.setText("");
        RegPasswordText.setText("");
        RegRepPasswordText.setText("");
        RegLastNameText.setText("");
        RegFirstNameText.setText("");
        UserNameText.setText("");
        PasswordText.setText("");
        SignInBtn.setDefaultButton(true);
    }

    @FXML
    void GotoRegisterBtn_click(ActionEvent event) {
        LoginPane.toBack();
        RegUserNameText.setText("");
        RegPasswordText.setText("");
        RegRepPasswordText.setText("");
        RegLastNameText.setText("");
        RegFirstNameText.setText("");
        UserNameText.setText("");
        PasswordText.setText("");
        UserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        PasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegUserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegRepPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegLastNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegFirstNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        SignInBtn.setDefaultButton(false);
    }

    @FXML
    void RegisterBtn_click(ActionEvent event) {
        DBModel dbModel = DBModel.getInstance();
        String userName = RegUserNameText.getText();
        String password = RegPasswordText.getText();
        String repPassword = RegRepPasswordText.getText();
        String firstName = RegFirstNameText.getText();
        String lastName = RegLastNameText.getText();
        RegUserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegRepPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegLastNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        RegFirstNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        boolean isAvailable=dbModel.checkUserName(userName);
        if(userName.equals("")|| !isAvailable) {
            RegUserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(firstName.equals("")){
            RegFirstNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(lastName.equals("")){
            RegLastNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(!password.equals(repPassword) || password.equals("") || password.length()<4){
            RegPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            RegRepPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(!userName.equals("") && !firstName.equals("") && !lastName.equals("") && !password.equals("")&& password.length()>=4 &&password.equals(repPassword) && isAvailable){
            dbModel.RegisterClient(userName,password,firstName,lastName);
            LoginPane.toFront();
            SignInBtn.setDefaultButton(true);
            RegUserNameText.setText("");
            RegPasswordText.setText("");
            RegRepPasswordText.setText("");
            RegLastNameText.setText("");
            RegFirstNameText.setText("");
        }
    }
    @FXML
    void SignInBtn_click(ActionEvent event) throws IOException {
        UserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        PasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        DBModel dbModel = DBModel.getInstance();
        String userName = UserNameText.getText();
        String password = PasswordText.getText();
        User c = dbModel.SignIn(userName, password);
        Stage stage;
        Scene scene;
        Parent root;

        if (c != null) {
            CurrentUser.setUser(c);
            root = FXMLLoader.load(getClass().getResource("../resources/views/MainMenuView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            UserNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red");
            PasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red");
        }
    }
}
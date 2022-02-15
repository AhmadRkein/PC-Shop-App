package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.DBModel;
import models.users.Client;
import models.users.CurrentUser;
import models.users.User;

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
        RegUserNameText.setText("");
        RegPasswordText.setText("");
        RegRepPasswordText.setText("");
        RegLastNameText.setText("");
        RegFirstNameText.setText("");
        UserNameText.setText("");
        PasswordText.setText("");
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
    }

    @FXML
    void RegisterBtn_click(ActionEvent event) {
        DBModel dbModel = DBModel.getInstance();
        String userName = RegUserNameText.getText();
        String password = RegPasswordText.getText();
        String repPassword = RegRepPasswordText.getText();
        String firstName = RegFirstNameText.getText();
        String lastName = RegLastNameText.getText();
        RegUserNameText.setStyle("-fx-border-color:black;");
        RegPasswordText.setStyle("-fx-border-color:black;");
        RegRepPasswordText.setStyle("-fx-border-color:black;");
        RegLastNameText.setStyle("-fx-border-color:black;");
        RegFirstNameText.setStyle("-fx-border-color:black;");
        if(userName.equals("")) {
            RegUserNameText.setStyle("-fx-border-color:red;");
        }
        if(firstName.equals("")){
            RegFirstNameText.setStyle("-fx-border-color:red;");
        }
        if(lastName.equals("")){
            RegLastNameText.setStyle("-fx-border-color:red;");
        }
        if(!password.equals(repPassword) || password.equals("") || password.length()<4){
            RegPasswordText.setStyle("-fx-border-color:red;");
            RegRepPasswordText.setStyle("-fx-border-color:red;");
        }
        if(!userName.equals("") && !firstName.equals("") && !lastName.equals("") && !password.equals("")&& password.length()>=4 ){
            dbModel.RegisterClient(userName,password,firstName,lastName);
            LoginPane.toFront();
            RegUserNameText.setText("");
            RegPasswordText.setText("");
            RegRepPasswordText.setText("");
            RegLastNameText.setText("");
            RegFirstNameText.setText("");
        }
    }
    @FXML
    void SignInBtn_click(ActionEvent event) {
        UserNameText.setStyle("-fx-border-color:black");
        PasswordText.setStyle("-fx-border-color:black");
        DBModel dbModel = DBModel.getInstance();
        String userName = UserNameText.getText();
        String password = PasswordText.getText();
        Client c = (Client) dbModel.SignIn(userName, password);
        if (c != null) {
            CurrentUser.setUser(c);
            User g=CurrentUser.getUser();
            System.out.println(g.getname());
        }
        else{
            UserNameText.setStyle("-fx-border-color:red");
            PasswordText.setStyle("-fx-border-color:red");
        }
    }
}

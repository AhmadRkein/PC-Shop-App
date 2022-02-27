package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import models.DBModel;

public class addEmployeeController {
    int isAdmin=0;

    @FXML
    private BorderPane MainPane;

    @FXML
    private TextField RegFirstNameText;

    @FXML
    private TextField RegLastNameText;

    @FXML
    private PasswordField RegPasswordText;

    @FXML
    private PasswordField RegRepPasswordText;

    @FXML
    private RadioButton radio_admin;

    @FXML
    private RadioButton radio_employee;

    @FXML
    private TextField RegUserNameText;

    @FXML
    private Button RegisterBtn;

    @FXML
    private VBox RegisterPane;

    @FXML
    public void initialize(){
        ToggleGroup toggleGroup=new ToggleGroup();
        radio_employee.setToggleGroup(toggleGroup);
        radio_admin.setToggleGroup(toggleGroup);
        radio_employee.setSelected(true);
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                ToggleButton selected= (RadioButton) toggleGroup.getSelectedToggle();
                if(selected.getText().equals(radio_employee.getText())){
                    isAdmin=0;
                }
                else if(selected.getText().equals(radio_admin.getText())){
                    isAdmin=1;
                }

            }
        });
    }

    @FXML
    void BackBtn_click(MouseEvent event) {

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
        boolean isAvailable=dbModel.checkUserName(userName,"employee");
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
            dbModel.RegisterEmployee(userName,password,firstName,lastName,isAdmin);
            RegUserNameText.setText("");
            RegPasswordText.setText("");
            RegRepPasswordText.setText("");
            RegLastNameText.setText("");
            RegFirstNameText.setText("");
        }
    }

}

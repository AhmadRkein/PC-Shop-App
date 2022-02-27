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
import models.users.CurrentUser;
import models.users.Employee;
import models.users.User;

import javax.naming.Name;

public class SettingsController {
    private int isAdmin=0;

    private Label NameLabel;

    @FXML
    private BorderPane addEmployeePane;

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
    private Button RegisterBtn;

    @FXML
    private VBox RegisterPane;

    @FXML
    private VBox RegisterPane1;

    @FXML
    private VBox RegisterPane2;

    @FXML
    private BorderPane editInfoPane;


    @FXML
    private Button go_to_addEmployee;

    @FXML
    private Button go_to_editInfo;

    @FXML
    private TextField newFirstNameText;

    @FXML
    private TextField newLastNameText;

    @FXML
    private PasswordField newPasswordText;

    @FXML
    private PasswordField newRepPasswordText;

    @FXML
    private RadioButton radio_admin;

    @FXML
    private RadioButton radio_employee;

    @FXML
    private BorderPane settingsPane;

    @FXML
    private Button submit_btn;

    @FXML
    private Button Reset_btn;

    @FXML
    public void initialize(){
        go_to_addEmployee.setManaged(false);
        if(CurrentUser.getUser() instanceof Employee){
            Employee employee=(Employee) CurrentUser.getUser();
            if(employee.isAdmin()){
                go_to_addEmployee.setManaged(true);
                go_to_addEmployee.setDisable(false);
            }
        }
        settingsPane.toFront();
        newFirstNameText.setText(CurrentUser.getUser().getFirstName());
        newLastNameText.setText(CurrentUser.getUser().getLastName());
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
            dbModel.RegisterEmployee(userName,password,firstName,lastName,isAdmin);
            RegUserNameText.setText("");
            RegPasswordText.setText("");
            RegRepPasswordText.setText("");
            RegLastNameText.setText("");
            RegFirstNameText.setText("");
            radio_employee.setSelected(true);
        }
    }

    @FXML
    void BackBtn_click(MouseEvent event) {
        editInfoPane.toBack();
        addEmployeePane.toBack();
        settingsPane.toFront();
        RegisterBtn.setDefaultButton(false);
        submit_btn.setDefaultButton(false);
    }


    @FXML
    void goToAddEmployee(ActionEvent event) {
        editInfoPane.toBack();
        settingsPane.toBack();
        addEmployeePane.toFront();

        RegUserNameText.setText("");
        RegPasswordText.setText("");
        RegRepPasswordText.setText("");
        RegLastNameText.setText("");
        RegFirstNameText.setText("");
        radio_employee.setSelected(true);

        RegisterBtn.setDefaultButton(true);
        submit_btn.setDefaultButton(false);
    }

    @FXML
    void goToEditInfo(ActionEvent event) {
        editInfoPane.toFront();
        settingsPane.toBack();
        addEmployeePane.toBack();

        ResetInfo(null);

        RegisterBtn.setDefaultButton(false);
        submit_btn.setDefaultButton(true);
    }

    @FXML
    void submitInfo(ActionEvent event) {
        DBModel dbModel = DBModel.getInstance();
        String password = newPasswordText.getText();
        String repPassword = newRepPasswordText.getText();
        String firstName = newFirstNameText.getText();
        String lastName = newLastNameText.getText();
        newPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        newRepPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        newLastNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        newFirstNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;");
        boolean error = false;
        if(firstName.equals("")){
            newFirstNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            error = true;
        }
        if(lastName.equals("")){
            newLastNameText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            error = true;
        }
        if(!password.equals(repPassword) || (!password.equals("") && password.length()<4)){
            newPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            newRepPasswordText.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            error = true;
        }
        if(!error){
            if(password.equals(""))
                password = CurrentUser.getUser().getpassword();
            dbModel.updateUserInfo(CurrentUser.getUser().getusername(),firstName,lastName,password);
            CurrentUser.setUser(dbModel.SignIn(CurrentUser.getUser().getusername(), password));
            newFirstNameText.setText(CurrentUser.getUser().getFirstName());
            newLastNameText.setText(CurrentUser.getUser().getLastName());
            settingsPane.toFront();
            if (NameLabel != null)
                NameLabel.setText(CurrentUser.getUser().getname());
        }
    }


    @FXML
    void ResetInfo(ActionEvent event) {
        newFirstNameText.setText(CurrentUser.getUser().getFirstName());
        newLastNameText.setText(CurrentUser.getUser().getLastName());
        newPasswordText.setText("");
        newRepPasswordText.setText("");
    }

    public void setNameLabel(Label label){
        NameLabel = label;
    }

    public Label getNameLabel(){
        return NameLabel;
    }

}

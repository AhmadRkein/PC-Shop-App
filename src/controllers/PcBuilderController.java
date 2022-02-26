package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import models.*;
import javafx.scene.image.ImageView;
import models.Product;

import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.ArrayList;
import java.util.ResourceBundle;




public class PcBuilderController implements Initializable {
    DBModel dbModel = DBModel.getInstance();
    @FXML
    private String Product;
    @FXML
    private Label MonitorLabel;

    @FXML
    private Label GPULabel;
    @FXML
    private Label RAMLabel;
    @FXML
    private Label CPULabel;
    @FXML
    private Label StorageLabel;
    @FXML
    private Label totalPrice;
    //monitors listing
    @FXML
    private ChoiceBox<Product> MonitorChoices;
    ArrayList<Monitor> Monitors = dbModel.getMonitorProducts();
    //GPU listing
    @FXML
    private ChoiceBox<Product> GPUChoices;
    ArrayList<GPU> GPUs = dbModel.getGpuProducts();
    //RAM listing
    @FXML
    private ChoiceBox<Product> RAMChoices;
    ArrayList<Ram> RAMs = dbModel.getRamProducts();
    //CPU listing
    @FXML
    private ChoiceBox<Product> CPUChoices;
    ArrayList<CPU> CPUs = dbModel.getCpuProducts();
    //HardDisk listing
    @FXML
    private ChoiceBox<Product> StorageChoices;
    ArrayList<HardDisk> HardDisks = dbModel.getHardDiskProducts();
    @FXML
    private Button gamingBtn;
    @FXML
    private Button addToCardBtn;
    @FXML
    private  Button budgetBtn;
    @FXML
    private Button customBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listing choices
        MonitorChoices.getItems().addAll(Monitors);
        MonitorChoices.setOnAction(this::getMonitor);

        GPUChoices.getItems().addAll(GPUs);
        GPUChoices.setOnAction(this::getGPU);

        RAMChoices.getItems().addAll(RAMs);
        RAMChoices.setOnAction(this::getRAM);

        CPUChoices.getItems().addAll(CPUs);
        CPUChoices.setOnAction(this::getCPU);

        StorageChoices.getItems().addAll(HardDisks);
        StorageChoices.setOnAction(this::getHardDisk);

        gamingBtn.setOnAction(this::setGamingPc);
        budgetBtn.setOnAction(this::setBudgetPc);

        addToCardBtn.setOnAction(this::addToCard);

    }
    public  float calculateTotalPrice(){

        float monitorPrice;
        float gpuPrice;
        float ramPrice;
        float cpuPrice;
        float hardDiskPrice;
        float total;

        Product monitor = (Product) MonitorChoices.getValue();
        Product gpu = (Product) GPUChoices.getValue();
        Product ram = (Product) RAMChoices.getValue();
        Product cpu = (Product) CPUChoices.getValue();
        Product hardDisk = (Product) StorageChoices.getValue();
        if(monitor == null){
            monitorPrice = 0;
        }else{
            monitorPrice = monitor.getPrice();
        }
        if(gpu == null){
            gpuPrice = 0;
        }else{
            gpuPrice = monitor.getPrice();
        }
        if(ram == null){
            ramPrice =0;
        }else{
            ramPrice = ram.getPrice();
        }
        if(cpu == null){
            cpuPrice = 0;
        }else{
            cpuPrice = cpu.getPrice();
        }
        if(hardDisk == null){
            hardDiskPrice = 0;
        }else{
            hardDiskPrice = hardDisk.getPrice();
        }
        total = monitorPrice + ramPrice + hardDiskPrice + cpuPrice + gpuPrice;
        return total;
    }
    @FXML
    public void setGamingPc(ActionEvent event){
          PCBuilder Builder = new GamingPCBuilder();
          PCBuilderDirector Director = new PCBuilderDirector(Builder);
          Director.constructPC();
          PC gamingPc = Director.getPC();
          MonitorChoices.setValue(gamingPc.getMonitor());
          GPUChoices.setValue(gamingPc.getGpu());
          RAMChoices.setValue(gamingPc.getRam());
          CPUChoices.setValue(gamingPc.getCpu());
          StorageChoices.setValue(gamingPc.getStorage());
          System.out.println(gamingPc.getDescription());
          gamingBtn.setStyle("-fx-background-color: #d33939 ;");
          budgetBtn.setStyle("-fx-background-color:  maroon;");
          customBtn.setStyle("-fx-background-color:  maroon;");
    }

    @FXML
    public void setBudgetPc(ActionEvent event)  {
        PCBuilder Builder = new BudgetPCBuilder();
        PCBuilderDirector Director = new PCBuilderDirector(Builder);
        Director.constructPC();
        PC gamingPc = Director.getPC();
        MonitorChoices.setValue(gamingPc.getMonitor());
        GPUChoices.setValue(gamingPc.getGpu());
        RAMChoices.setValue(gamingPc.getRam());
        CPUChoices.setValue(gamingPc.getCpu());
        StorageChoices.setValue(gamingPc.getStorage());
        System.out.println(gamingPc.getDescription());
        budgetBtn.setStyle("-fx-background-color: #d33939 ;");
        gamingBtn.setStyle("-fx-background-color:  maroon;");
        customBtn.setStyle("-fx-background-color:  maroon;");
    }
    public  void setCustomBtn(){
        customBtn.setStyle("-fx-background-color: #d33939 ;");
        gamingBtn.setStyle("-fx-background-color:  maroon;");
        budgetBtn.setStyle("-fx-background-color:  maroon;");
    }
    @FXML
    public void setCustomPc(ActionEvent event){
        customBtn.setStyle("-fx-background-color: #d33939;");
    }
    @FXML
    public void getMonitor(ActionEvent event){
        Product monitor = (Product) MonitorChoices.getValue();
        MonitorLabel.setText(monitor.getPrice() + " $");
        String totalP = String.valueOf(calculateTotalPrice());
        totalPrice.setText("total price " + totalP + " $");
        setCustomBtn();
    }
    @FXML
    public void getGPU(ActionEvent event){
        Product monitor = (Product) GPUChoices.getValue();
        GPULabel.setText(monitor.getPrice() + " $");
        String totalP = String.valueOf(calculateTotalPrice());
        totalPrice.setText("total price " + totalP + " $");
        setCustomBtn();
    }
    @FXML
    public void getRAM(ActionEvent event){
        Product monitor = (Product) RAMChoices.getValue();
        RAMLabel.setText(monitor.getPrice() + " $");
        String totalP = String.valueOf(calculateTotalPrice());
        totalPrice.setText("total price " + totalP + " $");
        setCustomBtn();
    }
    @FXML
    public void getCPU(ActionEvent event){
        Product monitor = (Product) CPUChoices.getValue();
        CPULabel.setText(monitor.getPrice() + " $");
        String totalP = String.valueOf(calculateTotalPrice());
        totalPrice.setText("total price " + totalP + " $");
        setCustomBtn();
    }
    @FXML
    public void getHardDisk(ActionEvent event){
        Product monitor = (Product) StorageChoices.getValue();
        StorageLabel.setText(monitor.getPrice() + "  $");
        String totalP = String.valueOf(calculateTotalPrice());
        totalPrice.setText("total price " + totalP + " $");
        setCustomBtn();
    }
    public void addToCard(ActionEvent event){
        Monitor monitor = (Monitor) MonitorChoices.getValue();
        GPU gpu = (GPU) GPUChoices.getValue();
        Ram ram = (Ram) RAMChoices.getValue();
        CPU cpu = (CPU) CPUChoices.getValue();
        HardDisk hardDisk = (HardDisk) StorageChoices.getValue();
        //build pc
        CustomPCBuilder Builder = new CustomPCBuilder();
        PC pc = Builder.BuildPc(cpu,gpu,ram,hardDisk,monitor);
        //save to db
        User user= CurrentUser.getUser();
        float totalPrice = calculateTotalPrice();
        dbModel.addPc(pc,user.getname(),totalPrice);
    }
}




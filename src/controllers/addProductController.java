package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import models.*;


public class addProductController {
    private String type;

    @FXML
    private BorderPane MainPane;

    @FXML
    private Label label_extra;

    @FXML
    private Label label_extra1;

    @FXML
    private Label label_extra2;

    @FXML
    private Label label_extra3;

    @FXML
    private RadioButton radioBtnCpu;

    @FXML
    private RadioButton radioBtnGpu;

    @FXML
    private RadioButton radioBtnHdd;

    @FXML
    private RadioButton radioBtnMonitor;

    @FXML
    private RadioButton radioBtnRam;

    @FXML
    private TextField txt_brand;

    @FXML
    private TextField txt_extra1;

    @FXML
    private TextField txt_extra2;

    @FXML
    private TextField txt_extra3;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_price;
    @FXML
    public void initialize(){
        //toggle category
        ToggleGroup radioGroup=new ToggleGroup();
        radioBtnCpu.setToggleGroup(radioGroup);
        radioBtnGpu.setToggleGroup(radioGroup);
        radioBtnRam.setToggleGroup(radioGroup);
        radioBtnMonitor.setToggleGroup(radioGroup);
        radioBtnHdd.setToggleGroup(radioGroup);
        //default is cpu tab
        radioBtnCpu.setSelected(true);
        label_extra.setText(("CPU Extra Details"));
        label_extra1.setText("Number of Cores");
        label_extra2.setText("Frequency");
        label_extra3.setVisible(false);
        txt_extra3.setVisible(false);
        type="cpu";
        //
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                txt_extra1.setText("");
                txt_extra2.setText("");
                txt_extra3.setText("");
                label_extra1.setVisible(true);
                label_extra2.setVisible(true);
                label_extra3.setVisible(true);
                txt_extra1.setVisible(true);
                txt_extra2.setVisible(true);
                txt_extra3.setVisible(true);
                RadioButton selected=(RadioButton) radioGroup.getSelectedToggle();
                if(selected.getText().equals(radioBtnCpu.getText())){
                    label_extra.setText(("CPU Extra Details"));
                    label_extra1.setText("Number of Cores");
                    label_extra2.setText("Frequency");
                    label_extra3.setVisible(false);
                    txt_extra3.setVisible(false);
                    type="cpu";
                }else if(selected.getText().equals(radioBtnRam.getText())){
                    label_extra.setText(("RAM Extra Details"));
                    label_extra1.setText("Size");
                    label_extra2.setVisible(false);
                    txt_extra2.setVisible(false);
                    label_extra3.setVisible(false);
                    txt_extra3.setVisible(false);
                    type="ram";
                }
                else if(selected.getText().equals(radioBtnGpu.getText())){
                    label_extra.setText(("GPU Extra Details"));
                    label_extra1.setText("ClockSpeed");
                    label_extra2.setText("Vram Size");
                    label_extra3.setText("Bus Type");
                    type="gpu";
                }
                else if(selected.getText().equals(radioBtnMonitor.getText())){
                    label_extra.setText(("Monitor Extra Details"));
                    label_extra1.setText("Screen Size");
                    label_extra2.setText("Resolution");
                    label_extra3.setVisible(false);
                    txt_extra3.setVisible(false);
                    type="monitor";
                }else if(selected.getText().equals(radioBtnHdd.getText())){
                    label_extra.setText(("Hard Disk Extra Details"));
                    label_extra1.setText("Storage Size");
                    label_extra2.setVisible(false);
                    txt_extra2.setVisible(false);
                    label_extra3.setVisible(false);
                    txt_extra3.setVisible(false);
                    type="harddisk";
                }
            }
        });
    }

    @FXML
    void reset_Handler(ActionEvent event) {
        txt_name.setText("");
        txt_brand.setText("");
        txt_price.setText("");
        txt_extra1.setText("");
        txt_extra2.setText("");
        txt_extra3.setText("");
    }

    @FXML
    void submit_handler(ActionEvent event) {
        DBModel dbModel= DBModel.getInstance();
        ProductFactory f=new ProductFactory();
        boolean valid=true;
        txt_name.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        txt_brand.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        txt_price.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        txt_extra1.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        txt_extra2.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");
        txt_extra3.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:black");

        if(txt_name.getText().equals("")){
            txt_name.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            valid=false;
        }
        if(txt_brand.getText().equals("")){
            txt_brand.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            valid=false;
        }
        if(txt_price.getText().equals("")||Float.parseFloat(txt_price.getText())<0){
            txt_price.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            valid=false;
        }
        if(txt_extra1.getText().equals("")){
            txt_extra1.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
            valid=false;
        }
        if(txt_extra2.getText().equals("")&&(type.equals("gpu")||type.equals("monitor")||type.equals("cpu"))){
            txt_extra2.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(txt_extra3.getText().equals("")&&type.equals("gpu")){
            txt_extra3.setStyle("-fx-background-radius:8;-fx-border-radius:8;-fx-border-color:red;");
        }
        if(valid) {
            Product product = f.GenerateProduct(type);
            product.setName(txt_name.getText());
            product.setBrand(txt_brand.getText());
            product.setPrice(Float.parseFloat(txt_price.getText()));
            if (type.equals("cpu")) {
                CPU cpu = (CPU) product;
                cpu.setCoresNb(Integer.parseInt(txt_extra1.getText()));
                cpu.setFreq(Float.parseFloat(txt_extra2.getText()));
                dbModel.addCpu(cpu);
            } else if (type.equals("gpu")) {
                if(!(txt_extra2.equals("")||txt_extra3.getText().equals(""))) {
                    GPU gpu = (GPU) product;
                    gpu.setClockSpeed(Integer.parseInt(txt_extra1.getText()));
                    gpu.setVramSize(Integer.parseInt(txt_extra1.getText()));
                    gpu.setBusType(txt_extra3.getText());
                    dbModel.addGpu(gpu);
                }
            } else if (type.equals("ram")) {
                Ram ram = (Ram) product;
                ram.setSize(Integer.parseInt(txt_extra1.getText()));
                dbModel.addRam(ram);
            } else if (type.equals("harddisk")) {
                HardDisk hdd = (HardDisk) product;
                hdd.setStorage(Integer.parseInt(txt_extra1.getText()));
                dbModel.addHardDisk(hdd);
            } else if (type.equals("monitor")) {
                if(!txt_extra2.equals("")){
                Monitor monitor = (Monitor) product;
                monitor.setSize(Integer.parseInt(txt_extra1.getText()));
                monitor.setResolution(txt_extra2.getText());
                dbModel.addMonitor(monitor);}
            }
            txt_name.setText("");
            txt_brand.setText("");
            txt_price.setText("");
            txt_extra1.setText("");
            txt_extra2.setText("");
            txt_extra3.setText("");
        }


    }

}

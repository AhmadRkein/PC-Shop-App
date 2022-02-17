package controllers;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.*;

import java.util.*;

public class BrowseShopController {

    private ObservableList<Product> displayedProducts;
    @FXML
    private ListView<Product> productsList;

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
    private ChoiceBox<String> sortChoiceBox;

    @FXML
    public void initialize(){
        //setting DB Connection and setting up the sorter

        DBModel dbModel=DBModel.getInstance();
        Sorter sorter=new Sorter();
        OrderStrategyByPriceAsc orderStrategyByPriceAsc=new OrderStrategyByPriceAsc();
        OrderStrategyByPriceDes orderStrategyByPriceDes=new OrderStrategyByPriceDes();
        OrderStrategyByName orderStrategyByName=new OrderStrategyByName();
        sorter.setOrderStrategy(orderStrategyByName);
        //toggle category
        ToggleGroup radioGroup=new ToggleGroup();
        radioBtnCpu.setToggleGroup(radioGroup);
        radioBtnGpu.setToggleGroup(radioGroup);
        radioBtnRam.setToggleGroup(radioGroup);
        radioBtnMonitor.setToggleGroup(radioGroup);
        radioBtnHdd.setToggleGroup(radioGroup);
        //default is cpu tab
        radioBtnCpu.setSelected(true);
        displayedProducts=FXCollections.observableArrayList(dbModel.getCpuProducts());
        productsList.getItems().addAll(displayedProducts);
        //change products by radiobutton
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton selected=(RadioButton) radioGroup.getSelectedToggle();
                if(selected.getText().equals(radioBtnCpu.getText())){
                    displayedProducts=FXCollections.observableArrayList(dbModel.getCpuProducts());

                }else if(selected.getText().equals(radioBtnRam.getText())){
                    displayedProducts=FXCollections.observableArrayList(dbModel.getRamProducts());

                }
                else if(selected.getText().equals(radioBtnGpu.getText())){
                    displayedProducts=FXCollections.observableArrayList(dbModel.getGpuProducts());

                }
                else if(selected.getText().equals(radioBtnMonitor.getText())){
                    displayedProducts=FXCollections.observableArrayList(dbModel.getMonitorProducts());

                }else if(selected.getText().equals(radioBtnHdd.getText())){
                    displayedProducts=FXCollections.observableArrayList(dbModel.getHardDiskProducts());

                }
                productsList.getItems().clear();
                productsList.getItems().addAll(displayedProducts);
            }
        });


     sortChoiceBox.getItems().addAll("By Name","By Price Ascending","By Price Descending");
     sortChoiceBox.setOnAction((event) -> {
        if(sortChoiceBox.getValue().equals("By Name")){
         sorter.setOrderStrategy(orderStrategyByName);
         }
         else if(sortChoiceBox.getValue().equals("By Price Ascending")){
             sorter.setOrderStrategy(orderStrategyByPriceAsc);
         }
         else if(sortChoiceBox.getValue().equals("By Price Descending")){
             sorter.setOrderStrategy(orderStrategyByPriceDes);
         }
         sorter.sort(displayedProducts);
         productsList.getItems().clear();
         productsList.getItems().addAll(displayedProducts);
     });

    }


}

package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import models.*;

import java.io.*;
import java.util.*;

public class BrowseShopController {


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
    private FlowPane ItemPanel;

    @FXML
    private AnchorPane InfoPane;

    @FXML
    private BorderPane MainPane;

    @FXML
    private Label ProductDesc;

    @FXML
    private ImageView ProductImage;



    private ArrayList<Product> displayedProducts;

    private ByteArrayOutputStream  outputstream;

    @FXML
    public void initialize(){
        MainPane.toFront();
        InfoPane.setDisable(true);
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

        InputStream stream = getClass().getResourceAsStream("../resources/views/ItemPaneView.fxml");
        outputstream = new ByteArrayOutputStream();
        try {
            stream.transferTo(outputstream);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //initialize displayedProducts
        displayedProducts = new ArrayList<Product>();
        setDisplayedProducts(dbModel.getCpuProducts());

        //change products by radiobutton
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton selected=(RadioButton) radioGroup.getSelectedToggle();
                if(selected.getText().equals(radioBtnCpu.getText())){
                    setDisplayedProducts(dbModel.getCpuProducts());

                }else if(selected.getText().equals(radioBtnRam.getText())){
                    setDisplayedProducts(dbModel.getRamProducts());

                }
                else if(selected.getText().equals(radioBtnGpu.getText())){
                    setDisplayedProducts(dbModel.getGpuProducts());

                }
                else if(selected.getText().equals(radioBtnMonitor.getText())){
                    setDisplayedProducts(dbModel.getMonitorProducts());

                }else if(selected.getText().equals(radioBtnHdd.getText())){
                    setDisplayedProducts(dbModel.getHardDiskProducts());

                }
                sortChoiceBox.fireEvent(new ActionEvent());
            }
        });
        //Sort products
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
            setDisplayedProducts(new ArrayList<>(displayedProducts));
        });

        sortChoiceBox.fireEvent(new ActionEvent());
    }

    private <type> void setDisplayedProducts(ArrayList<type> products) {
        ItemPanel.getChildren().clear();
        displayedProducts.clear();

        for (type p:products) {
            try {
                Node n = CreateItemPane((Product)p);
                ItemPanel.getChildren().add(n);
                displayedProducts.add((Product)p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Node CreateItemPane(Product p) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(new ByteArrayInputStream(outputstream.toByteArray()));
        ItemPaneController controller = fxmlLoader.getController();
        controller.setProduct(p);
        controller.setBrowseShop(this);

        return root;
    }

    @FXML
    void CloseBtn_Click(ActionEvent event) {
        InfoPane.setDisable(true);
        MainPane.setDisable(false);
        MainPane.toFront();
    }

    public void ViewInfo(Product p){
        MainPane.setDisable(true);
        InfoPane.setDisable(false);
        InfoPane.toFront();

        ProductImage.setImage(p.getImage());
        ProductDesc.setText(p.getDescription());
    }
}

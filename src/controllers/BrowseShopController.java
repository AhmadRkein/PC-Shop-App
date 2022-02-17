package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import models.DBModel;
import models.Product;
import models.Sorter;
import models.OrderStrategyByName;
import models.OrderStrategyByPriceAsc;
import models.OrderStrategyByPriceDes;
import java.util.ArrayList;

public class BrowseShopController {

    @FXML
    private ListView<String> productsList;

    @FXML
    private ChoiceBox<String> sortChoiceBox;

    @FXML
    public void initialize(){
        DBModel dbModel=DBModel.getInstance();
        Sorter sorter=new Sorter();
        OrderStrategyByPriceAsc orderStrategyByPriceAsc=new OrderStrategyByPriceAsc();
        OrderStrategyByPriceDes orderStrategyByPriceDes=new OrderStrategyByPriceDes();
        OrderStrategyByName orderStrategyByName=new OrderStrategyByName();
        ArrayList<Product> products=dbModel.getAllProducts();
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i).toString());
        }
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
         sorter.sort(products);
         for(int i=0;i<products.size();i++){
             System.out.println(products.get(i).toString());
         }
     });

    }


}

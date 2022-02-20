package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Sorter {
    private OrderStrategy str;
    public void setOrderStrategy(OrderStrategy Strategy){
        this.str=Strategy;
    }
    public OrderStrategy getOrderStrategy(){
        return str;
    }
    public void sort(ObservableList<Product> p){
        str.order(p);
    }
}

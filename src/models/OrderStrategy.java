package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

interface OrderStrategy {
    public void order(ArrayList<Product> p);
}

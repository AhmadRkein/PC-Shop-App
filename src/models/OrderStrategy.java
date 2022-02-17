package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

interface OrderStrategy {
    public void order(ObservableList<Product> p);
}

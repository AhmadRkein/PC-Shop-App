package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class OrderStrategyByName implements OrderStrategy {

    @Override
    public void order(ArrayList<Product> p) {
        Product tmp;
        for(int i=0;i<p.size();i++){
            for(int j=i+1;j<p.size();j++){
                if(p.get(i).getName().compareTo(p.get(j).getName())>0){
                    tmp=p.get(i);
                    p.set(i,p.get(j));
                    p.set(j,tmp);
                }
            }
        }
    }
}

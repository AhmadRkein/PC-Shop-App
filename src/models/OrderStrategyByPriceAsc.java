package models;

import java.util.ArrayList;

public class OrderStrategyByPriceAsc implements OrderStrategy {

    @Override
    public void order(ArrayList<Product> p) {
        Product tmp;
        for(int i=0;i<p.size();i++){
            for(int j=i+1;j<p.size();j++){
                if(p.get(i).getPrice()>p.get(j).getPrice()){
                    tmp=p.get(i);
                    p.set(i,p.get(j));
                    p.set(j,tmp);
                }
            }
        }
    }
}

package models;

import java.util.HashMap;

public class ProductFlyWeight {
	public static final HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();

	public static Product getProductById(int pid) {
		Product product = productMap.get(pid);
		if (product == null) {
			// TODO get Product from database
//			product = DBModel.getInstance().getProductByTID(pid);
			productMap.put(pid, product);
		}
		return product;
	}
}

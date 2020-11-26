package week05.d4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int getNumberOfExpired(){
        int counter = 0;
        for (Product one : products){
            if (one.getExpiringDate().isBefore(LocalDate.now())){
                ++counter;
            }
        }
        return counter;
    }
}
//7.5 perc

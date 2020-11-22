package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public double calculateTotalPrice(){
        Double sum = 0.;

        for ( Item one : items ) {
            sum += one.getPrice() * one.getQuantity();
        }
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }
}

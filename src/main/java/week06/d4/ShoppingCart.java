package week06.d4;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        Item temp = findItemByName(name);
        if (temp == null) {
            items.add(new Item(name, quantity));
            return;
        }
        temp.increaseQuantity(quantity);
    }

    public int getItem(String name) {
        Item result = findItemByName(name);
        if (result == null) {
            return 0;
        }
        return result.getQuantity();
    }

    private Item findItemByName(String name) {
        checkName(name);
        for (Item one : items) {
            if (one.getName().equals(name)) {
                return one;
            }
        }
        return null;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is a must!");
        }
    }
}
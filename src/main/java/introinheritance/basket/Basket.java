package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static final String ERROR_NO_ITEM = "Item is a must!";
    public static final String ERROR_NO_BARCODE = "Barcode is a must!";

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException(ERROR_NO_ITEM);
        }
        items.add(item);
    }

    public void removeItem(String barcode) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException(ERROR_NO_BARCODE);
        }
        for (int i = 0; i < items.size(); ++i) {
            if (barcode.equals(items.get(i).getBarcode())) {
                items.remove(i);
                return;
            }
        }
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}

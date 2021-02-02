package week14.d02;

public class Item {
    public static final String SEPARATOR = "\\(";
    public static final String ERROR_MESSAGE = "Invalid format!";

    private String product;
    private int price;

    public Item(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public Item(String combined) {
        String[] parts = combined.trim().split(SEPARATOR);
        if (parts.length != 2) throw new IllegalArgumentException(ERROR_MESSAGE);

        String number = parts[1].substring(0, parts[1].length() - 1);
        if (number.matches("[0-9]+")) {
            product = parts[0];
            price = Integer.parseInt(number);
        } else {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", product, price);
    }
}

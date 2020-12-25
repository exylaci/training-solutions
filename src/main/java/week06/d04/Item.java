package week06.d04;

public class Item {
    private String name;
    private int quantity;
    private int price;
    private int month;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Item(String name, int price, int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month!");

        this.name = name;
        this.price = price;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
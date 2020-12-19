package ioconvert.products;

public class Product {
    private String name;
    private int price;

    public Product(String name, int pieces) {
        this.name = name;
        this.price = pieces;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
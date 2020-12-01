package week06.d2;

public class Product {
    private String name;
    private Category category;
    private double price;

    public Product(String name, Category category, double price) {
        if (name == null || name.isBlank() || category == null) {
            throw new IllegalArgumentException("Name  and category is a must!");
        }
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

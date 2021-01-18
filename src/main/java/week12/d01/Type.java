package week12.d01;

public class Type implements Comparable {
    private int weight;
    private int price;

    public Type(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    private double getRate() {
        return (double) price / weight;
    }

    @Override
    public int compareTo(Object o) {
        return getRate() > ((Type) o).getRate() ? -1 : 1;
    }
}
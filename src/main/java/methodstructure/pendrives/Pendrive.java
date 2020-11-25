package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    void risePrice(int percent) {

        price = (int)Math.round(  price * ( 1 + percent/100.));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double pricePerCapacityOfThis = calculatePricePerCapacity();
        double pricePerCapacityOfOther = pendrive.calculatePricePerCapacity();
        return (int)Math.signum( pricePerCapacityOfThis - pricePerCapacityOfOther );
    }

    private double calculatePricePerCapacity(){
        return (double)getPrice() / getCapacity();
    }

    boolean cheaperThan(Pendrive pendrive){
        return price < pendrive.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %dGB, %dFt",name,capacity,price);
    }
}
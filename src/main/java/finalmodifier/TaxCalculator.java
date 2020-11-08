package finalmodifier;

public class TaxCalculator {
    public final double TAX = 0.27;

    public double tax(double price){
        return price * TAX;
    }

    public double priceWithTax(double price){
        return price + tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator tax = new TaxCalculator();

        System.out.println("TAX: " + tax.tax(100) );
        System.out.println("Gross price: " + tax.priceWithTax(100));
    }
}

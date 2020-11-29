package introinheritance.basket;

public class ShoppingBasket {
    public static final String ERROOR_EMPTY_BASKET = "This basket is empty!";
    private Basket basket = new Basket();


    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double total = 0;
        for (Item one : basket.getItems()) {
            total += one.getNettoPrice();
        }
        return total;
    }

    public double sumTaxValue() {
        double total = 0;
        for (Item one : basket.getItems()) {
            total += one.getTaxAmount();
        }
        return total;
    }

    public double sumBruttoPrice() {
        double total = 0;
        for (Item one : basket.getItems()) {
            total += one.getNettoPrice() + one.getTaxAmount();
        }
        return total;
    }

    public void checkout(){
        basket.clearBasket();
    }

    public void removeMostExpensiveItem(){

        String barcode =null;
        double maxPrice = Double.MIN_VALUE;

        for ( Item one : basket.getItems()){
            if(one.getNettoPrice()>maxPrice){
                maxPrice=one.getNettoPrice();
                barcode=one.getBarcode();
            }
        }
        if(maxPrice>Double.MIN_VALUE){
            basket.removeItem(barcode);
        }else {
            throw new IllegalArgumentException(ERROOR_EMPTY_BASKET);
        }

    }


}

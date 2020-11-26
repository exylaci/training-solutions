package week05.d4;

import java.time.LocalDate;

public class Product {
    private long price;
    private String currency;

    public Product(long price, String currency) throws  IllegalArgumentException {
        checkCurrency(currency);
        this.price = price;
        this.currency = currency;
    }

    public long convertPrice(String currency) throws IllegalArgumentException {
        checkCurrency(currency);
        if (this.currency == currency) {
            return price;
        }
        if (currency == "USD") {
            return price / 300;
        } else {
            return price * 300;
        }

    }

    private void checkCurrency(String currency) {
        if (currency == null || currency.isBlank() ||
                !currency.equals("USD") && !currency.equals("HUF")) {
            throw new IllegalArgumentException("Currency must be HUF or USD!");
        }
    }
}

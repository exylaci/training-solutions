package week05.d4;

import java.lang.invoke.StringConcatException;
import java.time.LocalDate;

public class Product {
    public static final String ERROR_MESSAGE = "Currency must be HUF or USD!";

    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.price = price;
        this.currency = currency;
    }

    public long convertPrice(Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (this.currency == currency) {
            return price;
        }
        if (currency == Currency.USD) {
            return price / 300;
        } else {
            return price * 300;
        }
    }
}

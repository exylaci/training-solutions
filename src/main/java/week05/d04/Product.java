package week05.d04;

import java.time.LocalDate;

public class Product {
    public static final String ERROR_MESSAGE = "Currency must be HUF or USD!";

    private long price;
    private Currency currency;

    private String name;
    private LocalDate expiringDate;

    public Product(long price, Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.price = price;
        this.currency = currency;
    }

    public Product(String name, int year, int month, int day) {
        this.name = name;
        this.expiringDate = LocalDate.of(year, month, day);
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

    public String getName() {
        return name;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }
}
//Készíts egy osztályt Product néven, melynek van egy
//  price (long) és egy
//  currency (String) mezője.
// A Product a konstruktorában ellenőrizze a currency mezőt, melynek az értéke vagy HUF, vagy USD lehet.
//
// Készíts egy metódust
// convertPrice() néven, melynek
//  egy paramétere van (currency) és visszaadja a currency-nek megfelelő összeget (double).
//
// Használjunk 300 forintos átváltási árfolyamot!
// Példa: ha a Product-ot létrehozzuk a következőképp: new Product(150, "HUF"),
//        majd meghívjuk a convertPrice-ot USD paraméterrel,
//        akkor az elvárt visszatérési érték 0.5.
//
//Bónusz feladat: Használj enum-ot String helyett a pénznem reprezentációjára!
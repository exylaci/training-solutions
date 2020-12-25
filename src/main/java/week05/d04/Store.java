package week05.d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getNumberOfExpired() {
        int counter = 0;
        for (Product one : products) {
            if (one.getExpiringDate().isBefore(LocalDate.now())) {
                ++counter;
            }
        }
        return counter;
    }
}
//7.5 perc

////Készíts egy Product osztályt melyben egy termékről tárolod a
//// nevét és a
//// lejárati dátumát (LocalDate)! Legyen egy
//// konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben
////  int year, int month, int day (public Product(String name, int year, int month, int day))!
//// A lejárati dátumot a konstruktorban állítsd össze!
//// Legyen mindkettőhöz getter metódus! Készíts egy
////
////Store osztályt, melyben van egy Product-okat tároló lista. Legyen benne egy
//// addProduct(Product) metódus!
////
////Bónusz: Legyen benne egy
//// getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát!
//// Használd a LocalDate.now() és az isBefore() metódusokat!
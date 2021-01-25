package lambdaprimitives;

import java.util.*;

public class SportGadgetStore {
    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products
                .stream()
                .mapToInt(product -> product.getPieces())
                .sum();
    }

    public double getAveragePrice() {
        OptionalDouble average = products
                .stream()
                .mapToDouble(Product::getPrice)
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        }
        return 0;
    }

    public String getExpensiveProductStatistics(double level) {
        IntSummaryStatistics result = products
                .stream()
                .filter(product -> product.getPrice() > level)
                .mapToInt(Product::getPieces)
                .summaryStatistics();
        if (result.getCount() == 0) {
            return "Nincs ilyen termék.";
        }

        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                result.getCount(),
                result.getMin(),
                result.getMax(),
                result.getSum());
    }
}
//Hozz létre egy Product osztályt, amely a sportszer nevét, árát, darabszámát tárolja! A konstruktora is ezeket kapja
//meg ugyanebben a sorrendben. A SportGadgetStore osztály tárolja a termékek listáját, és különböző statisztikákat
//készít belőle. Az osztály kapja meg a listát kívülről.
//
//Készítsd el a következő metódusokat streamek segítségével:
//  getNumberOfProducts(): összesen hány termék van a boltban,
//  getAveragePrice(): átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.
//  getExpensiveProductStatistics(double minPrice): adott árnál drágább termékek darabszámáról szolgáltat statisztikát.
//      Az összesítést szövegként adja vissza az alábbi formában:
//          Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.
//      Ha nincs ilyen, akkor a visszaadott szöveg a
//          Nincs ilyen termék. legyen!
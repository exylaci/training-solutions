package week06.d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Product list is a must!");
        }
        this.products = new ArrayList<>(products);
    }

    public List<Quantity> getProductsByCategory() {
        List<Quantity> quantities = new ArrayList<>();
        for (Product one : products) {
            appendNewCategory(quantities, one.getCategory());
            inrementPieces(quantities, one.getCategory());
        }
        return quantities;
    }

    private void inrementPieces(List<Quantity> quantities, Category category) {
        for (Quantity one : quantities) {
            if (one.getCategory() == category) {
                one.inrementPieces();
                return;
            }
        }
    }

    private void appendNewCategory(List<Quantity> quantities, Category category) {
        for (Quantity one : quantities) {
            if (one.getCategory() == category) {
                return;
            }
        }
        quantities.add(new Quantity(category));
    }
}
//Senior
//
//Hozz létre egy Product osztályt melynek adattagjai a
// név,
// kategória és
// ár.
//
// A kategória legyen enum FROZEN, DAIRY, BAKEDGOODS, OTHER felsorolókkal.
//
//Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
// Legyen egy getProductsByCategory() aminek az lényége, hogy
//  visszaadja valamilyen adatszerkezetben, hogy melyik kategóriából hány darab van a listában.
//
// A "valamilyen adatszerkezet" a kreativításodra van bízva, az
// a lényeg, hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van.
package week06.d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private List<Item> items = new ArrayList<>();

    public Budget(List<Item> items) {
        if (items == null) throw new IllegalArgumentException("List is a must!");
        this.items = new ArrayList<>(items);
    }

    public List<Item> getItemsByMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month!");

        List<Item> result = new ArrayList<>();

        for (Item one : items) {
            if (month == one.getMonth()) {
                result.add(one);
            }

        }
        return result;
    }
}
//Készíts az egy Budget osztályt, amely a
// konstruktorában Item példányokat vár listában (List).
// Az Item tartalmazza az alábbi attribútumokat:
//  int price,
//  int month,
//  String name.
//
//A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát.
// Írj egy metódust, getItemsByMonth néven, mely egy
// hónapot vár (1-12) és visszaadja az Item-eket az adott hónapban!
//
// Bónusz feladat: ellenőrizzük a bemeneti paramétereket!
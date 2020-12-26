package week09.d03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SantaClaus {
    private List<Person> people;

    public SantaClaus(List<Person> people) {
        if (people == null) throw new IllegalArgumentException("List cannot be empty!");
        this.people = new ArrayList<>(people);
    }

    public void getThroughChimneys(int seed) {
        Random random = new Random();
        if (seed > 0) {
            random = new Random(seed);
        }
        for (Person one : people) {
            one.setPresent(random);
        }
    }

    public List<Person> getPeople() {
        return List.copyOf(people);
    }
}
//A  mai feladatban Mikulásnak segítünk ajándékokat kiosztani.
//
//Készíts egy Present nevű enumot a következő felsorolókkal:
//  Toy, Electronic, Housekepping, Decoration. Ezek fogják az ajándékok típusát reprezentálni.
//
//Készíts egy Person osztályt legyen neki
// neve és életkora és legyen egy Present típusú attribútuma.
// A nevet és életkort konstruktorban kapja meg.
// Legyen egy setPresent() metódusa ami beállítja az ajándék attribútumot véletlenszerűen, egy kitétel van,
// 14 év fölötti nem kaphat játékot.
// Ennek megvalósításához szabadon bővíthetőek az eddig elkészült elemek.
//
// Legyen egy SantaClaus osztály, akinek van egy
// Person listája, amit konstruktorban kap meg. Legyen neki egy
// getThroughChimneys() metódusa, ami végigmegy az emberek listáján és meghívja minden ember setPresent() metódusát.
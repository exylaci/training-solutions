package week03.d02;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return name + ": " + bonus + " Ft";
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("cleaning staff", 50_000));
        positions.add(new Position("technician", 70_000));
        positions.add(new Position("team leader", 150_000));
        positions.add(new Position("officer", 150_001));
        positions.add(new Position("manager", 500_000));
        positions.add(new Position("CEO", 1_000_000));

        for (Position p : positions) {
            if (p.getBonus() > 150_000) {
                System.out.println(p);
            }
        }
    }
}
//Írj egy week03.Position osztályt, melynek van egy name és egy bonus attribútuma!
// Egy alkalmazotti pozíciót jelöl, melynek a bonus attribútuma tárolja, hogy
//ebben a pozícióban évente mennyi bónuszt kap egy alkalmazott.
//A main metódusban hozz létre egy Position objektumokat tartalmazo listát!
//
//Menj végig a lista elemein, és írd ki azokat, ahol a bónusz magasabb, mint
//150_000. Azonban a kiírás
//formátumát a Position osztály toString() metódusában implementáld!
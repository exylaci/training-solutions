package exam02;

public class ArraySelector {

    public String selectEvens(int[] source) {
        if (source == null || source.length == 0) return "";

        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < source.length; i += 2) {
            result.append(source[i]);
            result.append(", ");
        }
        return result.substring(0, result.length() - 2).toString() + "]";
    }
}
//Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat, és egy
// szövegként összerak, szögletes zárójelek között!
//
//A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem
// páratlan, stb.
//
//Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
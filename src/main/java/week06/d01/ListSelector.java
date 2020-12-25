package week06.d01;

import java.util.List;

public class ListSelector {

    public static String listSelector(List<String> words) {
        if (words == null) throw new IllegalArgumentException("List cannot be null!");
        if (words.size() == 0) return "";

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < words.size(); ++i) {
            if (i % 2 == 0) {
                result.append(words.get(i));
                result.append(" ");
            }
        }

        return result.toString().trim() + "]";
    }
}
//Írj egy olyan metódust az ListSelector osztályban, mely egy
// kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
// A páros megállapítása index szerint működik.
// Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
//
// Ha üres a lista, akkor üres stringet adjunk vissza.
// Ha a paraméterül kapott lista null, akkor dobj IllegalArgumentExceptiont a metódusban!
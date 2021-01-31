package week13.d05;

import java.util.HashSet;
import java.util.Set;

public class Counter {
    public int letterCounter(String text) {
        if (text == null) return 0;

        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.toUpperCase().charAt(i);
            if (c > '@' && c <= 'Z') {
                characters.add(c);
            }
        }
        return characters.size();
    }
}
//Írj egy metódust, amely megszámolja, hogy hány különböző betű van egy szóban.
//A kis és nagybetűk közötti különbség nem számít!
//A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az angol ábécé betűit!
package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class OwlCounter {

    public static final String SEPARATOR = "=";
    Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read!");
        }

    }

    private void processOneLine(String oneLine) {
        if (oneLine.isBlank()) return;

        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length == 2) {
            owls.put(parts[0], Integer.parseInt(parts[1]));
        }

    }

    public int getNumberOfOwls(String s) {
        return owls.get(s);
    }
}
//A OwlCounter oszály egy Map<String, Integer> attribútumban tárolja, hogy melyik megyében mennyi baglyot számoltak a
// madárszámlálók. A readFromFile() metódussal (paraméterezése, visszatérési értéke kiderül a tesztesetből) töltsd be az
// értékeket egy fájlból! A fájl formátuma a következő:
//
//Bács-Kiskun=1000
//Baranya=1050
//Békés=980
//Borsod-Abaúj-Zemplén=600
//
//A getNumberOfOwls() metódus adja vissza a baglyok számát a paraméterként átadott megyében!
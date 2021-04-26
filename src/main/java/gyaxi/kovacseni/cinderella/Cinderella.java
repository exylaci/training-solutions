package gyaxi.kovacseni.cinderella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Cinderella {
    private final String[] NAMES = {"Hamupipőke", "galamb", "királyfi", "mostoha", "cipő"};
    private int[] pieces = new int[NAMES.length];

    public int[] getNumbers() {
        return pieces;
    }

    public Object[] getMax() {
        Object[] result = new Object[2];
        result[1] = 0;
        for (int i = 0; i < pieces.length; ++i) {
            if (pieces[i] > (int) result[1]) {
                result[0] = NAMES[i];
                result[1] = pieces[i];
            }
        }
        return result;
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("cinderella.txt"), StandardCharsets.UTF_8))) {

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                splitToWords(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }

    private void splitToWords(String oneLine) {
        String[] words = oneLine.split(" ");
        for (String word : words) {
            count(word);
        }
    }

    private void count(String word) {
        for (int i = 0; i < NAMES.length; ++i) {
            if (word.toUpperCase().contains(NAMES[i].toUpperCase())) {
                ++pieces[i];
            }
        }
    }
}
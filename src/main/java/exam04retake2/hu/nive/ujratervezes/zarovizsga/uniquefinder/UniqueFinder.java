package exam04retake2.hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> uniqueChars(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null not accepted!");
        }

        List<Character> result = new ArrayList<>();
        Character character;
        for (int i = 0; i < text.length(); ++i) {
            character = text.charAt(i);

            if (!result.contains(character)) {
                result.add(character);
            }
        }

        return result;
    }
}

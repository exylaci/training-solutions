package week05.d02;

public class ChangeLetter {
    public final String REPLACE_FROM = "aeiou";
    public final char REPLACE_TO = '*';

    public String changeVowels(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        StringBuilder result = new StringBuilder(input.length());
        result.append(input);

        for (int i = 0; i < result.length(); ++i) {
            if (REPLACE_FROM.contains(result.substring(i, i + 1).toLowerCase())) {
                result.setCharAt(i, REPLACE_TO);
            }
        }

        return result.toString();
    }
}
//A ChangeLetter osztályban írj meg egy String changeVowels(String) metódust,
// mely kicseréli a paraméterként átadott szövegben az angol magánhangzókat csillag (*) karakterre.
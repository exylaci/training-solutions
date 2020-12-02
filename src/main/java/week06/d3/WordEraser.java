package week06.d3;

public class WordEraser {
    public static final String SPLITTER = " ";

    public String eraseWord(String words, String word) {
        if (words == null || words.isBlank() || word == null || word.isBlank()) {
            throw new IllegalArgumentException("Inputs cannot be empty!");
        }
        StringBuilder result = new StringBuilder(words.length());
        String[] split = words.split(SPLITTER);

        for (String one : split) {
            if (!word.equals(one)) {
                result.append(one);
                result.append(SPLITTER);
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}

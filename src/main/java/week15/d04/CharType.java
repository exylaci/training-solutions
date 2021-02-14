package week15.d04;

public enum CharType {

    VOWEL, CONSONANT, NUMBER, OTHER;

    public static final int NON_PRINTABLE = 32;
    public static final String VOWELS = "aáeéiíoóöőuúüű";

    public static boolean isPrintable(int c) {
        return c > NON_PRINTABLE;
    }

    public static CharType getType(int c) {
        if (VOWELS.contains(String.valueOf((char) c))) {
            return VOWEL;
        }
        if (c > (int) 'a' && c <= (int) 'z') {
            return CONSONANT;
        }
        if (c >= (int) '0' && c <= (int) '9') {
            return NUMBER;
        }
        return OTHER;
    }
}
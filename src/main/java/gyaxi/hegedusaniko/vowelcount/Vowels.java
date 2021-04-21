package gyaxi.hegedusaniko.vowelcount;

public class Vowels {

    public static int[] vowelCount(String text) {
        final String VOWELS = "aeiou";
        int[] counter = new int[5];

        for (char c : text.toLowerCase().toCharArray()) {
            for (int index = 0; index < VOWELS.length(); ++index) {
                if (c == VOWELS.charAt(index)) {
                    ++counter[index];
                }
            }
        }

        return counter;
    }

//    static int[] counter = new int[5];
//
//    public static int[] vowelCount(String text) {
//
//        for (char c : text.toLowerCase().toCharArray()) {
//            countIt(c);
//        }
//
//        return counter;
//    }
//
//    private static void countIt(char c) {
//        final String VOWELS = "aeiou";
//
//        for (int index = 0; index < VOWELS.length(); ++index) {
//            if (c == VOWELS.charAt(index)) {
//                ++counter[index];
//            }
//        }
//    }
}
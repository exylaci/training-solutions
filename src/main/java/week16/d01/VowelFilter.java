package week16.d01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;

public class VowelFilter {
    public static final String VOWELS = "aáeéiíoóöőuúüű";

    public String filterVowels(BufferedReader reader) {
        String oneLine;
        try {
            StringBuilder result = new StringBuilder();
            while ((oneLine = reader.readLine()) != null) {
                result.append(processOneLine(oneLine));
            }
            return result.toString();
        } catch (IOException e) {

            throw new IllegalStateException("Can't read from this reader!");
        }
    }

    private String processOneLine(String oneLine) {
        StringBuilder result = new StringBuilder();
        for (char c : oneLine.toCharArray()) {
            if (!VOWELS.contains(String.valueOf(c).toLowerCase(new Locale("hu", "HU")))) {
                result.append(c);
            }
        }
        return result.append("\n").toString();
    }

    public static void main(String[] args) {
        VowelFilter v = new VowelFilter();
        String source = "Aprócska\nKalapocska\nBenne\nCsacska\nMacska\nMocska";

        BufferedReader reader = new BufferedReader(new StringReader(source));

        System.out.println(v.filterVowels(reader));
    }
}
//Írj egy VowelFilter.filterFowels(BufferedReader reader) metódust, mely beolvas egy fájlt soronként, kiszűri belőle a
// magánhangzókat, és visszaadja egy String-ként.
//
//Tehát a bemeneti fájl tartalma:
//Aprócska
//Kalapocska
//Benne
//Csacska
//Macska
//Mocska
//
//Kimenet Stringként:
//prcsk
//Klpcsk
//Bnn
//Cscsk
//Mcsk
//Mcsk
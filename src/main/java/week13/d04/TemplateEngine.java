package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class TemplateEngine {

    public static final Locale LOCALE = new Locale("hu", "HU");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy. MMMM d.").withLocale(LOCALE);
    public static final NumberFormat NUMBER_FORMATTER = DecimalFormat.getCurrencyInstance(LOCALE);
    public static final String KEY_START = "{";
    public static final String KEY_CLOSE = "}";

    public void merge(BufferedReader reader, Map<String, Object> changes, BufferedWriter writer) {
        String oneLine;

        try {
            while ((oneLine = reader.readLine()) != null) {
                String newLine = replaces(oneLine, changes);
                writer.write(newLine);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read or write the file!");
        }
    }

    private String replaces(String oneLine, Map<String, Object> changes) {
        while (oneLine.contains(KEY_START)) {
            int begin = oneLine.indexOf(KEY_START);
            int end = oneLine.indexOf(KEY_CLOSE);

            String key = oneLine.substring(begin + 1, end);
            Object value = changes.get(key);

            String valueString;
            if (value instanceof LocalDate) {
                valueString = ((LocalDate) value).format(DATE_FORMATTER);
            } else if (value instanceof Double || value instanceof Float) {
                valueString = NUMBER_FORMATTER.format(value);
            } else {
                valueString = value.toString();
            }

            oneLine = oneLine.replace(KEY_START + key + KEY_CLOSE, valueString);
        }
        return oneLine;
    }
}
//Írj egy sablonkezelő rendszert! Hozz létre egy TemplateEngine nevezetű osztályt, benne egy
//void merge(BufferedReader reader, Map<String, Object>, BufferedWriter writer)
//metódussal. Az első paraméter a sablon, a második paraméter pedig az értékek, melyeket ki kell cserélni a sablonban.
//Képzeljük el, hogy ez a sablon:
//
//Kedves {nev}!
//
//Megküldjük önnek a következő esedékes számláját {datum} dátummal, melynek összege: {osszeg} Ft!
//A fizetési határidő {hatarido}.
//
//Üdvözlettel,
//Ügyfélszolgálat
//
//A metódus második paraméterként egy Map-ben kapja az értékeket:
//{"nev" = "John Doe", "datum" = LocalDate}
//
//A feladat, hogy a writer-be ki kell írni a levelet, de már kicserélve az értékeket.
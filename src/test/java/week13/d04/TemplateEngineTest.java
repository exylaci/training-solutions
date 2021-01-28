package week13.d04;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateEngineTest {

    @Test
    void merge() throws IOException {
        String template = """
                Kedves {nev}!

                Megküldjük önnek a következő esedékes számláját {datum} dátummal, melynek összege: {osszeg}!
                A fizetési határidő {hatarido}.

                Üdvözlettel,
                Ügyfélszolgálat""";

        Map<String, Object> changes = Map.of(
                "nev", "John Doe",
                "datum", LocalDate.of(2021, 01, 28),
                "osszeg", 30000.99,
                "hatarido", LocalDate.of(2021, 3, 17));

        StringReader source = new StringReader(template);
        BufferedReader reader = new BufferedReader(source);

        StringWriter result = new StringWriter();
        BufferedWriter writer = new BufferedWriter(result);

        new TemplateEngine().merge(reader, changes, writer);

        writer.flush();
        result.flush();

        String expected = """
                Kedves John Doe!
                                
                Megküldjük önnek a következő esedékes számláját 2021. január 28. dátummal, melynek összege: 30 000,99 Ft!
                A fizetési határidő 2021. március 17..
                                
                Üdvözlettel,
                Ügyfélszolgálat
                """;

        Scanner original = new Scanner(expected);
        Scanner outcome = new Scanner(result.toString());
        while (original.hasNext()) {
            assertEquals(original.nextLine(), outcome.nextLine());
        }
    }
}
package gyaxi.kovacseni.finelongword;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FineLongWord {
    public static final String PATH = "src/main/resources/gyaxi/kovacseni/finelongword";
    public static final String ERROR = "Can't read from file!";

    public char[] readFineLongWordFromFileAndGetItInAnArray(String fileName) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of(PATH).resolve(fileName), StandardCharsets.UTF_8)) {

            StringBuilder sb = new StringBuilder();
            sb.append(reader.readLine());

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                sb.append(oneLine.charAt(oneLine.length() - 1));
            }

            return sb.toString().toCharArray();

        } catch (IOException e) {
            throw new IllegalStateException(ERROR, e);
        }
    }
}
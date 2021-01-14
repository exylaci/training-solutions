package week11.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {
    public int sumNumbers(Path path) {
        int result = 0;

        for (int i = 0; i < 100; ++i) {
            Path oneFile = path.resolve(String.format("number%02d.txt", i));
            try {
                if (Files.isRegularFile(oneFile)) {
                    result += Integer.parseInt(Files.readString(oneFile));
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(String.format("Can't read number from file numbers%02d.txt !", i));
            }

        }
        return result;
    }
}
//Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
//Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
//számot, és ezt összegezd!
//
//Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
//Használd a Files.readString() metódust a fájl beolvasására!
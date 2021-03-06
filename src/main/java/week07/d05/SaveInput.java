package week07.d05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public void saveInput(Scanner scanner) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        List<String> lines = askLines(scanner);
        Path filename = askFileNamne(scanner);
        writeLinesToFile(filename, lines);
    }

    public void writeLinesToFile(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new IllegalArgumentException("Nem sikerült kiírni!", e);
        }
    }

    public Path askFileNamne(Scanner scanner) {
        System.out.print("Mi legyen a file neve: ");
        String filename = scanner.nextLine();
        return Path.of(filename);
    }

    public List<String> askLines(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        System.out.println("Kérek három sort!");
        for (int i = 0; i < 3; ++i) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }
}
//Kérj be a felhasználótól három sort,
// majd a fájl nevét.
// Mentsd el a sorokat ebbe a fájlba.
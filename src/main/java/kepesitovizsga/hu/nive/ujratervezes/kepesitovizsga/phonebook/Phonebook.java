package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String outputPath) {
        if (contacts == null || outputPath == null) {
            throw new IllegalArgumentException("Parameters cannot be null!");
        }

        if (outputPath.contains("/")) {
            createPath(outputPath);
        }

        exportContacts(contacts, outputPath);
    }

    private void exportContacts(Map<String, String> contacts, String outputPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath), StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

            for (Map.Entry<String, String> contact : contacts.entrySet()) {
                writer.write(contact.getKey() + ": " + contact.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot write the file!", e);
        }
    }

    private void createPath(String path) {
        try {

            Files.createDirectories(Path.of(path.substring(0, path.lastIndexOf("/"))));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot create directory!", e);
        }
    }
}
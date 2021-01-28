package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class TemplateEngine {

    public static final String KEY_START = "\\{";
    public static final String KEY_CLOSE = "\\}";

    public void merge(BufferedReader reader, Map<String, Object> changes, BufferedWriter writer) {
        String oneLine;

        try {
            while ((oneLine = reader.readLine()) != null) {
                oneLine = replaces(oneLine, changes);
                writer.write(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }

    }

    private String replaces(String oneLine, Map<String, Object> changes) {
        String[] parts = oneLine.split(KEY_START);
        if (parts.length == 1) return oneLine;

        StringBuilder newLine = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; ++i) {
            String[] subParts = parts[i].split(KEY_CLOSE);
            newLine.append(changes.get(subParts[0]).toString()).append(subParts[1]);
        }
        return newLine.toString();
    }

}

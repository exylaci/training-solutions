package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {
    private List<Example> examples = new ArrayList<>();

    public List<String> getTitlesOfExamples() {
        List<String> result = new ArrayList<>();
        for (Example one : examples) {
            result.add(one.getTitle());
        }
        return result;
    }

    public void loadExamples(String fileName) {
        if (fileName == null || fileName.isBlank()) throw new IllegalArgumentException("Filename is a must!");
        examples.clear();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream(fileName)));
            String oneLine;
            boolean valid = false;
            while (true) {
                if (!((oneLine = reader.readLine()) != null)) break;
                processOneLine(oneLine, valid);
            }
        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }

    private void processOneLine(String oneLine, boolean valid) {
        if (oneLine.isBlank()) return;

        if (oneLine.trim().charAt(0) == '#') {
            examples.add(new Example(oneLine.substring(1).trim()));
            valid = true;
        } else if (valid) {
            examples.get(examples.size() - 1).addToDescription(oneLine.trim());
        }
    }

    private class Example {
        final String title;
        List<String> description = new ArrayList<>();

        public Example(String title) {
            this.title = title;
        }

        public void addToDescription(String description) {
            this.description.add(description);
        }

        public String getTitle() {
            return title;
        }

        public List<String> getDescription() {
            return List.copyOf(description);
        }
    }
}
//Legyen a classpath-on egy `examples.md` fájl, mely a gyakorlati feladatok leírásait tartalmazza
//a következő formátumban! A `ExamplesStore` osztályba írj egy `getTitlesOfExamples()`
//metódust, mely visszaadja a feladatok címeit egy listában!
// ```
//# Első feladat
// Írj egy programot, amely
// kiírja az összeadás eredményét!
//# Második feladat
// Írj egy programot,
// mely kiírja a kivonás eredményét!
//```
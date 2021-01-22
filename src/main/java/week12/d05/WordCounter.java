package week12.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCounter {
    public int WordCounter(Path path) {
        if (path == null) throw new IllegalArgumentException("File name is a must!");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int counter = 0;
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                if (oneLine.toLowerCase().contains("virus")) {
                    ++counter;
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }

    public int WordCounter(URL url, String word) {
        if (url == null || word == null) throw new IllegalArgumentException("Parameters cannot be null!");

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     url.openStream()))) {
            int counter = 0;
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                if (oneLine.toLowerCase().contains(word)) {
                    ++counter;
                }
            }
            return counter;


        } catch (IOException e) {
            throw new IllegalStateException("Can't read from this URL: " + url);
        }

    }
}
//Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe (index.html) néven!
//Ez egy szöveges állomány. Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó! (edited)
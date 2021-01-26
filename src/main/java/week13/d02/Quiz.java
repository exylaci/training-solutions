package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {
    public static final String SEPARATOR = " ";

    private String correctAnswers;
    private Map<String, List<Character>> results = new HashMap<>();

    public void loadAnswers(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String oneLine;
            correctAnswers = reader.readLine();

            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from: " + path);
        }
    }

    private void processOneLine(String oneLine) {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length < 2) return;

        List<Character> answers;
        if (results.containsKey(parts[0])) {
            answers = results.get(parts[0]);
        } else {
            answers = new ArrayList<>();
        }
        answers.add(parts[1].toUpperCase().charAt(0));
        results.put(parts[0], answers);

    }

    public boolean isThisAnswerCorrect(String name, int answerNumber) {
        if (!results.containsKey(name) || answerNumber < 1 || answerNumber > 5) return false;
        return results.get(name).get(answerNumber + 1) == correctAnswers.charAt(answerNumber + 1);
    }

    public String whoPassedTheMostQuestions() {
        Optional<Map.Entry<String, List<Character>>> mostX =
                results.entrySet()
                        .stream()
                        .max((a, b) -> (int) (a.getValue().stream().filter(answer -> answer == 'X').count() -
                                b.getValue().stream().filter(answer -> answer == 'X').count()));

        if (mostX.isPresent()) {
            return mostX.get().getKey();
        }
        return "No one has passed even a single question.";
    }

    //Ez "szebb" de sokkal költségesebb, mert duplán meg kell keresni minden elemet a MAP-ben.
    public String whoPassedTheMostQuestions2() {
        Optional<Map.Entry<String, List<Character>>> mostX =
                results.entrySet()
                        .stream()
                        .max(Comparator.comparingInt(a -> getNumberOfPasses(a.getKey())));

        if (mostX.isPresent()) {
            return mostX.get().getKey();
        }
        return "No one has passed even a single question.";
    }

    private int getNumberOfPasses(String name) {
        return (int) results.get(name)
                .stream()
                .filter(answer -> answer == 'X')
                .count();
    }

    public String getWinner() {
        Optional<Map.Entry<String, List<Character>>> winner = results
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(a -> getScore(a.getKey())));

        if (winner.isPresent()) {
            return winner.get().getKey();
        }
        return "No one has won.";
    }

    private int getScore(String name) {
        int score = 0;
        List<Character> answers = results.get(name);
        for (int i = 0; i < Math.min(correctAnswers.length(), answers.size()); ++i) {
            if (correctAnswers.charAt(i) == answers.get(i)) {
                score += i + 1;
            } else if (answers.get(i) != 'X') {
                score -= 2;
            }
        }
        return score;
    }


    public Map<String, List<Character>> getResults() {
        return results;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }
}
//Egy internetes kvíz versenyen egy fájlba rögzitettük a versenyzők válaszait. A versenyzők egyszerre kezdtek és
// egyszerre egy kérdésre válaszoltak meg. A fájlban az egyes versenyzők válaszai sorban szerepelnek, de a fájlban a
// sorok a beérkezett válaszok sorrendjében találhatók.
//
// PL.:
//ABACD
//AB123 A
//AH2 B
//BD452 A
//AB123 B
//GH1234 C
//
//Magyarázat:A fájl első sora a helyes válaszokat tartalmazza egy sorban. (5 kérdés volt az elsőre a helyes válasz A a
// másodikra B stb.) Ezek után a sor első eleme egy azonosító a második pedig egy a válasz betűjele. Minden kérdésnél
// négy válaszlehetőség volt (A,B,C,D) és lehetett ugrani egy kérdést ekkor X szerepel a fájlban.
//Tehát az AB123 azonosítóval rendelkező játékos első válasza A a második B. A többieknek csak az első kérdésre adott
// válaszuk szerepel a példában.
//
//
//Feladatok:
//1. Olvasd be a fájl tartalmát a memóriába.
//2. Legyen egy lekérdező metódus ami paraméterül vár egy kódot és egy számot és megmondja hogy az ileltő az adott
//   kérdésre helyesen vagy helytelenül válaszolt-e.
//3. Legyen egy metódus ami visszaadja annak versenyzőnek a kódját, akinek a legtöbb X szerepel a válaszai között.
//4. Adjuk vissza annak a versenyzőnek a kódját, aki a legtöbb pontot szerezte. Pont a helyes válaszért jár méghozzá
//   annyi, ahányadik kérdés volt a sorban. Az első kérdés egy pontos a második kettő stb.
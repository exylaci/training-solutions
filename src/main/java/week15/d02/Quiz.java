package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Quiz {
    public static final String SEPARATOR = " ";
    private Map<String, List<Question>> quiz = new HashMap<>();

    public void loadFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String[] twoLine = new String[2];
            int index = 0;
            while ((twoLine[index] = reader.readLine()) != null) {
                ++index;
                if (index == 2) {
                    processOneQuestion(twoLine);
                    index = 0;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void processOneQuestion(String[] twoLine) {
        String[] parts = twoLine[1].split(SEPARATOR);
        if (!quiz.containsKey(parts[2])) {
            quiz.put(parts[2], new ArrayList<>());
        }
        Question question = new Question(twoLine[0], parts[0], Integer.parseInt(parts[1]));
        quiz.get(parts[2]).add(question);
    }

    public List<String> getQuestions(String topic) {
        return quiz.get(topic)
                .stream()
                .map(Question::getQuestion)
                .collect(Collectors.toList());
    }

    public Question getAQuestion(int seed) {
        Random rnd = new Random(seed);

        Object[] topics = quiz.keySet().toArray();
        String topic = (String) topics[rnd.nextInt(topics.length)];

        int numberOfQuestions = quiz.get(topic).size();
        return quiz.get(topic).get(rnd.nextInt(numberOfQuestions));
    }

    public static void main(String[] args) {
        Quiz k = new Quiz();
        k.loadFromFile(Path.of("src/main/resources/week15/d02/kerdesek.txt"));
        k.getAQuestion(20);
    }

    public Map<String, List<Question>> getAllQuestion() {
        return quiz;
    }

    public String maxScoresTopic() {
        int maxScore = 0;
        String result = null;
        for (Map.Entry<String, List<Question>> group : quiz.entrySet()) {
            int sum = group.getValue().stream()
                    .map(Question::getScore)
                    .reduce(0, (acc, next) -> acc += next, (acc, next) -> acc += next);
            if (sum > maxScore) {
                result = group.getKey();
                maxScore = sum;
            }
        }
        return result;
    }
}
//Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
// Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava. Olvasd be a fájl
// tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.
//
//Mikor volt a mohacsi vesz?
//1526 1 tortenelem
//Melyik evben bomlott fel a Nyugat-Romai Birodalom?
//476 1 tortenelem
//Melyik a legkisebb primszam?
//2 1 matematika
//Mennyi 64 kobgyoke?
//4 2 matematika
//Hany atloja van a szabalyos nyolcszognek?
//24 2 matematika
//Melyik evben kezdodott a Honfoglalas?
//895 1 tortenelem
//Mikor adtak ki az Aranybullat?
//1222 1 tortenelem
//Melyik evben adtak ki Angliaban a Magna Chartat?
//1215 3 tortenelem
//
//1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
//2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
//3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben témánként
//   megtalálható az összes kérdés.
//4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
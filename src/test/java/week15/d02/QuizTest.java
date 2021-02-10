package week15.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    static Quiz k = new Quiz();

    @BeforeAll
    public static void init() {
        k.loadFromFile(Path.of("src/main/resources/week15/d02/kerdesek.txt"));
    }

    @Test
    void loadFromFileTest() {
        assertEquals(57, k.getAllQuestion().entrySet().stream().flatMap(a -> a.getValue().stream()).count());

    }

    @Test
    void getQuestionsTest() {
        assertEquals(21, k.getQuestions("matematika").size());
    }


    @Test
    void getAQuestionTest() {
        assertEquals("Mennyi 5 faktorialisa?", k.getAQuestion(20).getQuestion());
        assertEquals("Mennyi az oxigen rendszama?", k.getAQuestion(99).getQuestion());
    }

    @Test
    void maxScoresTopicTest() {
        assertEquals("matematika", k.maxScoresTopic());
    }
}
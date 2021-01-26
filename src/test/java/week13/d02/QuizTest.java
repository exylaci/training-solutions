package week13.d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    @Test
    void loadAnswersTest() {
        Quiz q = new Quiz();
        q.loadAnswers(Path.of("src/main/resources/week13/d02/results.txt"));
        assertEquals(4, q.getResults().size());

//        System.out.println(q.getResults());
//        System.out.println(q.getCorrectAnswers());
    }

    @Test
    void isThisAnswerCorrectTest() {
        Quiz q = new Quiz();
        q.loadAnswers(Path.of("src/main/resources/week13/d02/results.txt"));

        assertTrue(q.isThisAnswerCorrect("AH2", 3));
        assertFalse(q.isThisAnswerCorrect("BD452", 3));
    }

    @Test
    void getMostXTest() {
        Quiz q = new Quiz();
        q.loadAnswers(Path.of("src/main/resources/week13/d02/results.txt"));

        assertEquals("BD452", q.whoPassedTheMostQuestions());
    }

    @Test
    void getWinnerTest() {
        Quiz q = new Quiz();
        q.loadAnswers(Path.of("src/main/resources/week13/d02/results.txt"));

        assertEquals("GH1234", q.getWinner());
    }
}
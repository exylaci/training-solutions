package week08.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExamplesStoreTest {
    @Test
    void loadExamplesTest(){
        ExamplesStore es = new ExamplesStore();
        es.loadExamples("examples.md");
    }

    @Test
    void getTitlesOfExamplesTest(){
        ExamplesStore es = new ExamplesStore();
        es.loadExamples("examples.md");

        List<String> examples = es.getTitlesOfExamples();

        assertEquals(2,examples.size());
        assertEquals("Első feladat",examples.get(0));
        assertEquals("Második feladat",examples.get(1));
    }

    @Test
    void loadExamplesWithoutFilenameTest(){
        ExamplesStore es = new ExamplesStore();
        Exception exception = assertThrows( IllegalArgumentException.class,()->
            es.loadExamples(null));
        assertEquals("Filename is a must!", exception.getMessage());
    }

    @Test
    void loadExamplesWrongFilenameTest(){
        ExamplesStore es = new ExamplesStore();
        Exception exception = assertThrows( IllegalStateException.class,()->
            es.loadExamples("examples..md"));
        assertEquals("Can't read from file!", exception.getMessage());
    }
}
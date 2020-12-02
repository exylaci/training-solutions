package week06.d3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordEraserTest {
    @Test
    public void eraseWordParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new WordEraser().eraseWord(null, "Nincs szöveg."));
        assertEquals("Inputs cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new WordEraser().eraseWord("\n", "Nincs szöveg."));
        assertEquals("Inputs cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new WordEraser().eraseWord("Jó szöveg, de nincs cserélendő.", null));
        assertEquals("Inputs cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new WordEraser().eraseWord("Jó szöveg, de nincs cserélendő.", "\n"));
        assertEquals("Inputs cannot be empty!", exception.getMessage());
    }

    @Test
    public void eraseWordTest() {
        assertEquals("Sok szót, lehet beleírni, de mindent nem fog kicserélni.",
                new WordEraser().eraseWord("Sok sok szót, lehet beleírni, de sok mindent nem fog kicserélni.",
                        "sok"));
    }

}

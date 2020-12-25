package week06.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {
    @Test
    void listSelectorTest() {
        assertEquals(
                "[nulladik második negyedik]",
                ListSelector.listSelector(List.of("nulladik", "első", "második", "harmadik", "negyedik")));
        assertEquals(
                "",
                ListSelector.listSelector(List.of()));
    }

    @Test
    void listSelectorParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ListSelector.listSelector(null));
        assertEquals("List cannot be null!", exception.getMessage());
    }
}

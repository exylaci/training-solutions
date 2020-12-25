package week06.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {
    @Test
    void getItemsByMonthTest() {
        List<Item> sample = List.of(
                new Item("konzerv", 1000, 1),
                new Item("tészta", 800, 2),
                new Item("kenyér", 360, 2),
                new Item("sajt", 7000, 2),
                new Item("tej", 320, 1));

        Budget b = new Budget(sample);
        List<Item> result = b.getItemsByMonth(2);
        assertEquals(3, result.size());
        assertEquals("kenyér", result.get(1).getName());
    }

    @Test
    void getItemsByMonthParameterTest() {
        Budget b = new Budget(List.of());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                b.getItemsByMonth(0));
        assertEquals("Invalid month!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                b.getItemsByMonth(13));
        assertEquals("Invalid month!", exception.getMessage());
    }

    @Test
    void constructorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Budget(null));
        assertEquals("List is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Budget(List.of(new Item("konzerv", 1000, 0))));
        assertEquals("Invalid month!", exception.getMessage());
    }
}
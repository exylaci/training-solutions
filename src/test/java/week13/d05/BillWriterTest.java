package week13.d05;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class BillWriterTest {

    @Test
    void writeBills1Test() {
        List<BillItem> temp = List.of(
                new BillItem("termék 1", 312, 5),
                new BillItem("termék 2", 653, 17));

        String result = new BillWriter().writeBills(temp, new WriteLine1());

        String expected = """
                5 termék 1, darabja 312 Ft.
                17 termék 2, darabja 653 Ft.
                """;

        assertEquals(expected, result);
    }

    @Test
    void writeBills2Test() {
        List<BillItem> temp = List.of(
                new BillItem("termék 1", 312, 5),
                new BillItem("termék 2", 653, 17));

        String result = new BillWriter().writeBills(temp, new WriteLine2());

        String expected = """
                Megnevezés           Egységár (Ft) Darab Összeg
                termék 1                       312     5   1560
                termék 2                       653    17  11101
                """;

        assertEquals(expected, result);
    }

    @Test
    void writeBills3Test() {
        List<BillItem> temp = List.of(
                new BillItem("termék 1 neve", 312, 5),
                new BillItem("termék 2 neve", 653, 17));

        String result = new BillWriter().writeBills(temp, new WriteLine3());

        String expected = """
                termék 1 neve 5 * 312 = 1560
                termék 2 neve 17 * 653 = 11101
                """;

        assertEquals(expected, result);
    }
}
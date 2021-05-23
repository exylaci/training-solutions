package erettsegik.majus2018.tarsalgo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {
    private static final String DATA_FILE = "src/main/resources/erettsegik/majus2018/tarsalgo/ajto.txt";
    private static Logic logic;

    @TempDir
    Path tempDirectory;

    @BeforeAll
    static void init() {
        logic = new Logic(DATA_FILE);
    }

    @Test
    void feladat2_More() {
        Map<String, Integer> result = logic.feladat2(10, 24);

        assertEquals(15, result.get("first in"));
        assertEquals(29, result.get("last out"));
    }

    @Test
    void feladat2_NoOne() {
        Map<String, Integer> result = logic.feladat2(10, 12);

        assertEquals(0, result.size());
    }

    @Test
    void feladat2_OnlyIn() {
        Map<String, Integer> result = logic.feladat2(14, 17);

        assertEquals(1, result.size());
        assertEquals(22, result.get("first in"));
    }

    @Test
    void feladat2_OnlyOut() {
        Map<String, Integer> result = logic.feladat2(14, 38);

        assertEquals(1, result.size());
        assertEquals(16, result.get("last out"));
    }

    @Test
    void feladat3() throws IOException {
        logic.feladat3(tempDirectory);

        assertTrue(Files.exists(tempDirectory.resolve("athaladas.txt")));

        List<String> result = Files.readAllLines(tempDirectory.resolve("athaladas.txt"));

        assertEquals(35, result.size());
        assertEquals("1 21", result.get(0));
        assertEquals("41 12", result.get(34));
    }

    @Test
    void feladat4() {
        assertTrue(Set.of(1, 11, 22, 24, 29, 30, 35, 37).equals(logic.feladat4()));
    }

    @Test
    void felaldat5() {
        LocalTime result = logic.feladat5();

        assertEquals(10, result.getHour());
        assertEquals(44, result.getMinute());
    }

    @Test
    void felaldat7_notExistsId() {
        assertTrue(logic.feladat7(51).isEmpty());
    }

    @Test
    void felaldat7_2() {
        assertEquals("09:01-09:18", logic.feladat7(2).get(0));
    }

    @Test
    void felaldat7_22() {
        assertTrue(List.of("11:22-11:27", "13:45-13:47", "13:53-13:58", "14:17-14:20", "14:57-").equals(logic.feladat7(22)));
    }

    @Test
    void felaldat7_39() {
        assertEquals(6, logic.feladat7(39).size());
    }

    @Test
    void feladat8_18() {
        Result8 result = logic.feladat8(18);

        assertFalse(result.isIn());
        assertEquals(57, result.getLength());
    }

    @Test
    void feladat8_22() {
        Result8 result = logic.feladat8(22);

        assertTrue(result.isIn());
        assertEquals(15 + 3, result.getLength());
    }
}
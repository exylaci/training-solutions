package week13.d01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SettlementsTest {

    static Settlements s = new Settlements();

    @BeforeAll
    public static void init() {
        Path path = Path.of("src/main/resources/iranyitoszamok-varosok-2021.csv");
        s.loadFromFile(path);
    }

    @Test
    void getFirstTest() {
        assertEquals("Aba", s.getFirst().getName());
    }

    @Test
    void getLongestName() {
        assertEquals("Jászfelsőszentgyörgy", s.getLongestName().getName());
    }
}
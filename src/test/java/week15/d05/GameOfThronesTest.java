package week15.d05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {
    static GameOfThrones g = new GameOfThrones();

    @BeforeAll
    static void init() {
        g.loadFromFile(Path.of("src/main/resources/week15/d05/battles.csv"));
    }

    @Test
    void loadFromFileTest() {
        assertEquals(38, g.getBottles().size());
    }

    @Test
    void findMostFightingHouseTest() {
        assertEquals("Lannister", g.findMostFightingHouse());
    }
}
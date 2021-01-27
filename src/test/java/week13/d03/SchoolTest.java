package week13.d03;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    void loadScheduleTest() {
        School s = new School();
        s.loadSchedule(Path.of("src/main/resources/week13/d03/beosztas.txt"));

        assertEquals(329, s.getSchedule().size());
    }

    @Test
    void summarisingTheWorkedHours() {
        School s = new School();
        s.loadSchedule(Path.of("src/main/resources/week13/d03/beosztas.txt"));

        assertEquals(24, s.summarisingTheWorkedHours("Albatrosz Aladin"));
    }
}
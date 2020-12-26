package week07.d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabTest {
    @Test
    public void LabTest() {
        assertEquals(Lab.Completed.NOT_COMPLETED, new Lab("Fizika").getCompleted());

        Lab lab1 = new Lab("Kémia", LocalDate.of(2020, 1, 2));
        assertEquals(Lab.Completed.COMPLETED, lab1.getCompleted());
        assertEquals(LocalDate.of(2020, 1, 2), lab1.getCompletedAt());

        Lab lab2 = new Lab("Fizika");
        assertEquals(Lab.Completed.NOT_COMPLETED, lab2.getCompleted());
        lab2.completed();
        assertEquals(Lab.Completed.COMPLETED, lab2.getCompleted());
        assertEquals(LocalDate.now(), lab2.getCompletedAt());
    }
}
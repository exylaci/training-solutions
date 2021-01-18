package week12.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGrades() {
        GradeRounder g = new GradeRounder();

        assertArrayEquals(new int[]{39, 40, 41, 42, 45, 45, 45, 46, 47, 50, 50, 50},
                g.roundGrades(new int[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}));
    }
}
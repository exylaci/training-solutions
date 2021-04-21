package gyaxi.hegedusaniko.standarddev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviationTest {

    @Test
    void standardDeviationTest() {
        Deviation d = new Deviation();

        assertEquals(11.237, d.standardDeviation(new double[]{1, -2, 4, -4, 9, -6, 16, -8, 25, -10}), 0.005);
        assertEquals(7.905, d.standardDeviation(new double[]{5, 10, 15, 20, 25}), 0.005);
        assertEquals(0.0, d.standardDeviation(new double[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}), 0.005);
        assertEquals(0.774, d.standardDeviation(new double[]{2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4}), 0.005);
        assertEquals(1.414, d.standardDeviation(new double[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5}), 0.005);
    }
}
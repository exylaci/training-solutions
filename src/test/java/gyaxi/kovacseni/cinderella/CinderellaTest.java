package gyaxi.kovacseni.cinderella;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CinderellaTest {

    private Cinderella cinderella;

    @BeforeEach
    public void setUp() {
        cinderella = new Cinderella();
        cinderella.readFromFile();
    }

    @Test
    public void readFromFile() {
        Assertions.assertEquals(12, cinderella.getNumbers()[1]);
        Assertions.assertEquals(22, cinderella.getNumbers()[3]);
    }

    @Test
    public void getMax() {
        Object[] expected = cinderella.getMax();

        Assertions.assertEquals("Hamupipőke", expected[0]);
        Assertions.assertEquals(32, expected[1]);
    }
}
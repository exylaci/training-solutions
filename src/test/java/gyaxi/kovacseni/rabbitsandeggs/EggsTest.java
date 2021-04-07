package gyaxi.kovacseni.rabbitsandeggs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EggsTest {

    @Test
    public void testGetRabbitWithMaxEggs() {
        Rabbit rabbit = new Eggs().getRabbitWithMaxEggs();

        Assertions.assertEquals("Nyunyi", rabbit.getName());
        Assertions.assertEquals(32, rabbit.getEggs());
    }
}
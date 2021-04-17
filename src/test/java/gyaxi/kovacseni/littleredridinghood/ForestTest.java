package gyaxi.kovacseni.littleredridinghood;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForestTest {

    @AfterEach
    public void tearDown() {
        LittleRedRidingHood.cake = 10;
        Forest.playersOfTheTale = new ArrayList<>(Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász")));
    }

    @Test
    public void testWolfEat() {
        List<Forest> playersAtTheBeginningOfTheTale = Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász"));

        Assertions.assertEquals(playersAtTheBeginningOfTheTale, Forest.playersOfTheTale);

        Wolf wolf = new Wolf("Farkas");
        wolf.eat();
        List<Forest> playersAfterWolfCame = Arrays.asList(new Wolf("Farkas"), new Hunter("Vadász"));

        Assertions.assertEquals(playersAfterWolfCame, Forest.playersOfTheTale);
    }

    @Test
    public void testLittleRedRidingHoodEat() {

        Assertions.assertEquals(10, LittleRedRidingHood.cake);

        LittleRedRidingHood littleRedRidingHood = new LittleRedRidingHood("Piroska");
        littleRedRidingHood.eat();

        Assertions.assertEquals(9, LittleRedRidingHood.cake);

        littleRedRidingHood.eat();

        Assertions.assertEquals(8, LittleRedRidingHood.cake);
    }

    @Test
    public void testGrandmaEat() {

        Assertions.assertEquals(10, LittleRedRidingHood.cake);

        Grandma grandma = new Grandma("Nagymama");
        grandma.eat();

        Assertions.assertEquals(8, LittleRedRidingHood.cake);
    }

    @Test
    public void testHunterEat() {
        List<Forest> playersAtTheBeginningOfTheTale = Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász"));

        Assertions.assertEquals(playersAtTheBeginningOfTheTale, Forest.playersOfTheTale);
        Assertions.assertEquals(10, LittleRedRidingHood.cake);

        Wolf wolf = new Wolf("Farkas");
        wolf.eat();
        List<Forest> playersAfterWolfCame = Arrays.asList(new Wolf("Farkas"), new Hunter("Vadász"));

        Assertions.assertEquals(playersAfterWolfCame, Forest.playersOfTheTale);

        Hunter hunter = new Hunter("Vadász");
        hunter.eat();
        List<Forest> playersAtTheEndOfTheTale = Arrays.asList(new Hunter("Vadász"), new Grandma("Nagymama"), new LittleRedRidingHood("Piroska"));

        Assertions.assertEquals(playersAtTheEndOfTheTale, Forest.playersOfTheTale);
        Assertions.assertEquals(7, LittleRedRidingHood.cake);
    }
}
package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {
    @Test
    void trainerTest() {
        Trainer trainerGoodMood = new Trainer(new GoodMood());
        Trainer trainerBadMood = new Trainer(new BadMood());

        assertEquals(5, trainerGoodMood.giveMark());
        assertEquals(3, trainerBadMood.giveMark());
    }
}
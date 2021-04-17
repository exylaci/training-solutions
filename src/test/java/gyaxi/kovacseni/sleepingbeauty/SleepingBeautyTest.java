package gyaxi.kovacseni.sleepingbeauty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SleepingBeautyTest {

    @Test
    public void countCharacters() {
        Map<Character, Integer> letters = new SleepingBeauty().countCharacters("sleepingbeauty.txt");

        Assertions.assertEquals(32, letters.size());
        Assertions.assertEquals(113, letters.get('f'));
        Assertions.assertEquals(522, letters.get('o'));
        Assertions.assertEquals(30, letters.get('ú'));
        Assertions.assertNull(letters.get('.'));
        Assertions.assertNull(letters.get('1'));
    }
}
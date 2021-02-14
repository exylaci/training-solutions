package week15.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {

    @Test
    void counterByChartypeTest() {
        Map<CharType, Long> result = new CharacterCounter().
                counterByChartype(Path.of("src/main/resources/week14/d05/hachiko.srt"));

        assertEquals(6528L, result.get(CharType.VOWEL));
        assertEquals(10373L, result.get(CharType.CONSONANT));
        assertEquals(17729L, result.get(CharType.NUMBER));
        assertEquals(9621L, result.get(CharType.OTHER));
    }
}
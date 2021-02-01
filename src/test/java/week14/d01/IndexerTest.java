package week14.d01;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {
    @Test
    void index() {
        Map<Character, List<String>> result = new Indexer().index(
                List.of("Abraham", "Adam", "Ajtony", "Lujza", "Ludmilla", "Odon", "Lujza", "Abraham", "Magdolna"));

        assertEquals(4, result.size());
        assertLinesMatch(List.of("Abraham", "Adam", "Ajtony", "Abraham"), result.get('A'));
    }
}
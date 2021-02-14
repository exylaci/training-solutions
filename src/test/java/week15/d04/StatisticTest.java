package week15.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticTest {

    @Test
    void findMax3CasesTest() {
        List<StatisticResult> result = new Statistic().findMax3Cases(
                Path.of("src/main/resources/week15/d05/data.csv"),
                "Hungary");

        assertEquals(3,result.size());
    }
}
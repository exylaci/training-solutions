package week15.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    @Test
    void maxCasesPerPersonTest() {
        Statistic s = new Statistic();
        List<Result> result = s.maxCasesPerPerson(Path.of("src/main/resources/week15/d05/data.csv"));

        System.out.println(result);
    }
}
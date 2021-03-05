package graduateproject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CitiesDaoTest {
    public static MariaDbDataSource source;

    @BeforeAll
    public static void init() {
        try {
            source = new MariaDbDataSource();
            source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
            source.setUser("vaccine");
            source.setPassword("vaccine");
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to GRADUATE_PROJECT database!", e);
        }
    }

    @Test
    void initialize() throws IOException {
        CitiesDao citiesDao = new CitiesDao(source);
        BufferedReader reader = Files.newBufferedReader(Path.of("src/test/resources/graduateproject/cities.txt"));

        citiesDao.initializeDao(reader);

        assertEquals("Bedő", citiesDao.getCityDao("4128"));
    }
}

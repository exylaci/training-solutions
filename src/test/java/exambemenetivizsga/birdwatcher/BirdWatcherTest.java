package exambemenetivizsga.birdwatcher;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BirdWatcherTest {
    private static final List<String> EXPECTED_SPECIES =
            List.of("american robin", "downy woodpecker", "house sparrow", "northern cardinal");

    private BirdWatcher birdWatcher;
    private MariaDbDataSource dataSource;


    @BeforeEach
    void init() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway
                .configure()
                .locations("filesystem:src/test/resources/exambemenetivizsga/db/migration")
                .dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        birdWatcher = new BirdWatcher(dataSource);
    }

    @Test
    void test_getUniqueBirds_allBirdsOnce_anyOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES.size(), actualSpecies.size());
        for (String bird : EXPECTED_SPECIES) {
            assertTrue(actualSpecies.contains(bird));
        }
    }

    @Test
    void test_getUniqueBirds_allBirdsOnce_alphabeticOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES, actualSpecies);
    }

    @Test
    void test_getUniqueBirds_oneDuplicate_anyOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES.size(), actualSpecies.size());
        for (String bird : EXPECTED_SPECIES) {
            assertTrue(actualSpecies.contains(bird));
        }
    }

    @Test
    void test_getUniqueBirds_empty_database() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("DELETE FROM birds_spotted");

        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertTrue(actualSpecies.isEmpty());
    }
}
package erettsegik.majus2020.akademikusok;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

class LogicTest {

    static MariaDbDataSource source;
    static Logic logic;

    @BeforeAll
    static void init() throws SQLException {
        source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/akademikusok?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");

        logic = new Logic(source);
    }

    @BeforeEach
    void prepare() {
        Flyway flyway = Flyway
                .configure()
                .locations("filesystem:src/test/resources/erettsegik/majus2020/akademikusok")
                .dataSource(source)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void teszt() {
        System.out.println("Lefutott :) ");
    }
}
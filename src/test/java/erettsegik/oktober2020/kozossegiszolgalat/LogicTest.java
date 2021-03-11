package erettsegik.oktober2020.kozossegiszolgalat;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LogicTest {

    static MariaDbDataSource source;

    @BeforeAll
    static void ini() throws SQLException {
        source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/kozossegi?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");
    }

    @BeforeEach
    void prepare() {
        Flyway flyway = Flyway.configure().locations("filesystem:src/test/resources/erettsegik/oktober2020/kozossegiszolgalat").dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void iskolaik() {
        List<String> result = new Logic(source).iskolaik();
        assertTrue(result.size() > 0);
    }

    @Test
    void oraszamok() {
        assertTrue(new Logic(source).oraszamok().get() > 0);
    }

    @Test
    void teljesitettek() {
        List<Report4> result = new Logic(source).teljesitettek();
        assertTrue(result.size() > 0);
    }

    @Test
    void tobbszor() {
        List<Report5> result = new Logic(source).tobbszor();
        assertTrue(result.size() > 0);
    }

    @Test
    void senki() {
        List<Report6> result = new Logic(source).senki();
        assertTrue(result.size() > 0);
    }

    @Test
    void stat() {
        Map<String, Integer> result = new Logic(source).stat();
        assertTrue(result.size() > 0);
    }
}
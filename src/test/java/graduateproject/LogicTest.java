package graduateproject;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    public static MariaDbDataSource source;


    @BeforeAll
    public static void initialize() throws SQLException {
        source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
        source.setUser("vaccine");
        source.setPassword("vaccine");

        Flyway flyway = Flyway.configure().locations("filesystem:src/test/resources/graduateproject").dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void GetCity() {
        assertEquals("", new Logic(source).getCity(""));
        assertEquals("", new Logic(source).getCity("0000"));
        assertEquals("Tahitótfalu, Tótfalu", new Logic(source).getCity("2021"));
        assertEquals("Szár;Újbarok", new Logic(source).getCity("2066"));
        assertEquals("Bedő", new Logic(source).getCity("4128"));
    }

    @Test
    void registrationFromFile() throws SQLException {
        Logic logic = new Logic(source);
        List<String> errorlog = new ArrayList<>();
        logic.registrationFromFile(
                "src/test/resources/graduateproject/citizensGroupLoad.csv",
                errorlog);

        assertEquals(0, errorlog.size());

        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT zip FROM citizens");
        result.last();
        int lastIndex = result.getRow();
        result.close();
        statement.close();
        connection.close();

        assertEquals(57, lastIndex);
    }
}

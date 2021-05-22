package erettsegik.oktober2018.laprendeles;

import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

class DaoTest {

    @Test
    void createTables() throws SQLException {
        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/erettsegi?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");

        new Dao(source).initialisation();
    }
}
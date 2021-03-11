package erettsegik.oktober2020.kozossegiszolgalat;

import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    @Test
    void loadDataFromFiles() throws SQLException {
        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/kozossegi?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");

        Dao dao = new Dao(source);
        dao.init();
        FileOperations f = new FileOperations(source);
        f.loadDataFromTextFiles();

        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM diak WHERE id=429");
        result.last();
        String nev = result.getString("nev");
        String osztaly = result.getString("osztaly");
        result.close();

        result = statement.executeQuery("SELECT * FROM jelentkezes WHERE diakid=194 AND munkaid=7588");
        result.last();
        boolean ervenyes = result.getBoolean("ervenyes");
        boolean elfogadva = result.getBoolean("elfogadva");
        boolean teljesitve = result.getBoolean("teljesitve");
        result.close();

        result = statement.executeQuery("SELECT * FROM munka WHERE id=8031");
        result.last();
        LocalDate datum = result.getDate("datum").toLocalDate();
        LocalTime kezdes = result.getTime("kezdes").toLocalTime();
        int hossz = result.getInt("hossz");
        int maxLetszam = result.getInt("maxletszam");
        int tevekenysegId = result.getInt("tevekenysegid");
        result.close();

        result = statement.executeQuery("SELECT * FROM tevekenyseg WHERE id=48");
        result.last();
        String tevekenysegNev = result.getString("nev");
        boolean iskolai = result.getBoolean("iskolai");
        result.close();

        statement.close();
        connection.close();

        assertEquals("Vőneki Milán", nev);
        assertEquals("10/B", osztaly);

        assertTrue(ervenyes);
        assertTrue(elfogadva);
        assertFalse(teljesitve);

        assertEquals(LocalDate.of(2017, 8, 25), datum);
        assertEquals(LocalTime.of(8, 0, 0), kezdes);
        assertEquals(4, hossz);
        assertEquals(1, maxLetszam);
        assertEquals(43, tevekenysegId);

        assertEquals("ifjúsági műsor készítése", tevekenysegNev);
        assertFalse(iskolai);
    }
}
package erettsegik.oktober2018.laprendeles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {
    static Logic logic;

    @BeforeAll
    static void upLoad() throws SQLException {
        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/erettsegi?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");

        logic = new Logic(source);
        logic.upLoad("src/main/resources/erettsegik/oktober2018/laprendeles/lap.txt",
                "src/main/resources/erettsegik/oktober2018/laprendeles/elofizeto.txt",
                "src/main/resources/erettsegik/oktober2018/laprendeles/elofizetes.txt");
    }

    @Test
    void havi2() {
        Map<String, Integer> result = logic.havi2();

        assertEquals(23, result.size());

        for (Integer price : result.values()) {
            assertFalse(price == 0);
        }
        assertEquals(2300, result.get("168 Óra"));
    }

    @Test
    void tobb3() {
        List<Elofizeto> result = logic.tobb3();

        assertEquals(12, result.size());
        assertEquals("Duma Árpád", result.get(0).getNev());
        assertEquals("Dagály utca", result.get(5).getUtca());
        assertEquals("3", result.get(11).getHazszam());
    }

    @Test
    void osszesen4() {
        assertEquals(176180, logic.osszesen4("Bodor utca", "13"));
    }

    @Test
    void osszesen4NotExistsAddress() {
        assertEquals(0, logic.osszesen4("nem létező utca", "rossz házszám"));
    }

    @Test
    void kedvezmeny5() {
        assertEquals("Magyar Hírlap", logic.kedvezmeny5());
    }

    @Test
    void egyutt6_1() {
        List<String> result = logic.egyutt6("Magyar Nemzet");

        assertEquals(16, result.size());
        assertTrue(result.contains("Élet és Irodalom"));
        assertFalse(result.contains("Magyar Nemzet"));
    }

    @Test
    void egyutt6_2() {
        List<String> result = logic.egyutt6("Élet és Irodalom");

        assertEquals(8, result.size());
        assertFalse(result.contains("Élet és Irodalom"));
    }

    @Test
    void heti7() {
        Map<Elofizeto, String> result = logic.heti7();

        assertEquals(4, result.size());
        assertEquals("168 Óra", result.get(new Elofizeto("Senkey Tamás", "Népfürdő utca", "10")));
    }

    @Test
    void ritkan8() {
        List<Lap> result = logic.ritkan8();

        assertEquals(42, result.size());
    }
}
package week12.d04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {
    public static Map<String, Client> temp = new TreeMap<>();

    @BeforeAll
    public static void init() {
        temp.put("regnumber1", new Client("regnumber1", "name1"));
        temp.put("regnumber2", new Client("regnumber2", "name2"));
        temp.put("regnumber3", new Client("regnumber3", "name3"));
        temp.put("regnumber4", new Client("regnumber4", "name4"));
        temp.put("regnumber5", new Client("regnumber5", "name5"));
        temp.put("regnumber6", new Client("regnumber6", "name6"));
    }

    @Test
    void findByRegNumberTest() {
        assertEquals("name4", new Clients(temp).findByRegNumber("regnumber4").getName());
    }

    @Test
    void findByRegNumberFailedTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Clients(temp).findByRegNumber("not existing regNumber"));
        assertEquals("There is no this regnumber: not existing regNumber", exception.getMessage());
    }

    @Test
    void findByNameExistsInNameTest() {
        List<Client> result = new Clients(temp).findByName("me");
        assertEquals(6, result.size());
    }

    @Test
    void findByNameExistsInKeyTest() {
        assertEquals(0, new Clients(temp).findByName("eg").size());
    }
}
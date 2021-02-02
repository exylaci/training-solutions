package week14.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OnlineShopTest {

    public static OnlineShop o = new OnlineShop();

    @BeforeAll
    public static void init() {
        o.loadFromFile(Path.of("src/main/resources/week14/d02/OnlineShoppings.txt"));
    }

    @Test
    void loadFromFileTest() {
        OnlineShop o = new OnlineShop();
        o.loadFromFile(Path.of("src/main/resources/week14/d02/OnlineShoppings.txt"));

        assertEquals(9, o.getBuyings().size());
    }

    @Test
    void loadFromFileParameterTest() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new OnlineShop().loadFromFile(null));
        assertEquals("Can't read from file: null", exception.getMessage());
    }

    @Test
    void getProductsTest() {
        assertEquals(Collections.emptyList(), o.getProducts(null));

        List<String> result = o.getProducts("W34111");
        assertEquals(8, result.size());
        assertEquals("pasta", result.get(3));
    }

    @Test
    void countSoldPiecesTest() {
        assertEquals(0, o.countSoldPieces(null));
        assertEquals(2, o.countSoldPieces("pasta"));
        assertEquals(3, o.countSoldPieces("sugar"));
    }

    @Test
    void countProductsTesst() {
        assertEquals(0, o.countProducts(null));
        assertEquals(6, o.countProducts("C123"));
    }

    @Test
    void createStatistic() {
        Map<String, Long> result = o.createStatistic();
        assertEquals(27, result.size());
        assertEquals(2, result.get("cheese"));
    }
}
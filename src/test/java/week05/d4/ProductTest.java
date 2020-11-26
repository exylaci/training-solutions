package week05.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void convertPriceTest() {
        assertEquals(300, new Product(300, "USD").convertPrice("USD"));
        assertEquals(90000, new Product(300, "USD").convertPrice("HUF"));
        assertEquals(300, new Product(300, "HUF").convertPrice("HUF"));
        assertEquals(1, new Product(300, "HUF").convertPrice("USD"));
    }
    @Test
            public void validationTest(){

        Exception ex = assertThrows( IllegalArgumentException.class, () ->
                new Product(1,null));
        assertEquals("Currency must be HUF or USD!", ex.getMessage());

        ex = assertThrows( IllegalArgumentException.class, () ->
                new Product(1,""));
        assertEquals("Currency must be HUF or USD!", ex.getMessage());

        ex = assertThrows( IllegalArgumentException.class, () ->
                new Product(1,"EUR"));
        assertEquals("Currency must be HUF or USD!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, ()->
                new Product(1,"HUF").convertPrice("EUR"));
    }
}

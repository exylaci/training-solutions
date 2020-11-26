package week05.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void convertPriceTest() {
        assertEquals(300, new Product(300, Currency.USD).convertPrice(Currency.USD));
        assertEquals(90000, new Product(300, Currency.USD).convertPrice(Currency.HUF));
        assertEquals(300, new Product(300, Currency.HUF).convertPrice(Currency.HUF));
        assertEquals(1, new Product(300, Currency.HUF).convertPrice(Currency.USD));
    }

    @Test
    public void validationTest() {

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Product(1, null));
        assertEquals(Product.ERROR_MESSAGE, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () ->
                new Product(1, Currency.HUF).convertPrice(null));
        assertEquals(Product.ERROR_MESSAGE, ex.getMessage());
    }
}

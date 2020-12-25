package week06.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    @Test
    public void constructorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Product(null, Category.OTHER, 34));
        assertEquals("Name  and category is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Product("\n", Category.OTHER, 34));
        assertEquals("Name  and category is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Product("null termék kategória", null, 34));
        assertEquals("Name  and category is a must!", exception.getMessage());
    }
}
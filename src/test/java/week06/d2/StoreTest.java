package week06.d2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StoreTest {

    @Test
    public void constructorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Store(null));
        assertEquals("Product list is a must!", exception.getMessage());
    }

    @Test
    public void getProductsByCategoryTest() {
        Store store = new Store(Arrays.asList(
                new Product("jégkocka", Category.FROZEN, 113.45),
                new Product("tészta", Category.DAIRY, 435.6),
                new Product("kenyér", Category.BAKEDGOODS, 367),
                new Product("sör", Category.OTHER, 1000),
                new Product("croissant", Category.BAKEDGOODS, 134.5),
                new Product("pizza", Category.FROZEN, 786.4),
                new Product("tej", Category.OTHER, 359.8)
        ));

        List<Quantity> quantities = store.getProductsByCategory();
        assertEquals(4, quantities.size());
        assertEquals(2, quantities.get(0).getPieces());
        assertEquals(1, quantities.get(1).getPieces());
        assertEquals(2, quantities.get(2).getPieces());
        assertEquals(2, quantities.get(3).getPieces());
    }

}

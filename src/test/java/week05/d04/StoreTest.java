package week05.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {
    @Test
    public void addProductAndGetNumberOfExpiredTest() {
        Store store = new Store();
        store.addProduct(new Product("alma", 2020, 11, 25));
        store.addProduct(new Product("körte", 2120, 11, 26));
        store.addProduct(new Product("szilva", 2120, 11, 27));
        store.addProduct(new Product("alma", 2000, 11, 25));
        assertEquals(2, store.getNumberOfExpired());
    }
}
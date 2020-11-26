package week05.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void convertPriceTest() {
        Store store = new Store();
        store.addProduct(new Product( "alma",2020,11,25));
        store.addProduct(new Product( "körte",2120,11,26));
        store.addProduct(new Product( "szilva",2120,11,27));
        assertEquals( 1,store.getNumberOfExpired());
    }
}
//11:20 perc
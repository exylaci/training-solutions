package week06.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {
    @Test
    public void addSameItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("fa", 3);
        shoppingCart.addItem("fa", 3);
        assertEquals(6, shoppingCart.getItem("fa"));
    }

    @Test
    public void addDifferentItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("fa", 4);
        shoppingCart.addItem("bokor", 2);
        assertEquals(4, shoppingCart.getItem("fa"));
    }

    @Test
    public void getItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getItem("fa"));
    }

    @Test
    public void addItemExceptionTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                shoppingCart.addItem(null, 1));
        assertEquals("Name is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                shoppingCart.addItem("", 1));
        assertEquals("Name is a must!", exception.getMessage());
    }
}
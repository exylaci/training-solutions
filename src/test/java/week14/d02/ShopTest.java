package week14.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    public static Shop s = new Shop();

    @BeforeAll
    public static void init() {
        s.loadShoppingListFromFile("ShoppingLists.txt");
//        System.out.println(s.getShoppings());
    }

    @Test
    void loadShoppingListFromFileParameterTest() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Shop().loadShoppingListFromFile(null));
        assertEquals("Can't read from file: null", exception.getMessage());
    }

    @Test
    void loadShoppingListFromFileTest() {
        Shop s = new Shop();
        s.loadShoppingListFromFile("ShoppingLists.txt");

        assertEquals(9, s.getShoppings().size());
    }

    @Test
    void summOfOneShoppingTest() {
        assertEquals(7100, s.summOfOneShopping("120"));
    }

    @Test
    void totalSpentOfACustomerTest() {
        assertEquals(9650, s.totalSpentOfACustomer("SM123"));
    }

    @Test
    void countAProductTest() {
        assertEquals(0, s.countAProduct(null));
        assertEquals(3, s.countAProduct("tomato"));
        assertEquals(1, s.countAProduct("soda"));
    }

    @Test
    void productsCounterTest() {
        assertEquals(27, s.productsCounter().size());
        assertEquals(3, s.productsCounter().get("tomato"));
    }

    @Test
    void getOrderedOneShoppinglistOrderByNameTest() {
        assertEquals(Collections.emptyList(), s.getOrderedOneShoppinglist(null, null, null));

//        List<Item> result = s.getOrderedOneShoppinglist("SM123", "120", Item::getProduct);
        List<Item> result = s.getOrderedOneShoppinglist("SM123", "120", Comparator.comparing(Item::getProduct));
        assertEquals(7, result.size());
        assertEquals("fish", result.get(2).getProduct());
    }

    @Test
    void getOrderedOneShoppinglistOrderByPriceTest() {
//        List<Item> result = s.getOrderedOneShoppinglist("SM123", "120", Item::getPrice);
        List<Item> result = s.getOrderedOneShoppinglist("SM123", "120", Comparator.comparing(Item::getPrice));
        assertEquals(7, result.size());
        assertEquals("potato", result.get(2).getProduct());
    }
}
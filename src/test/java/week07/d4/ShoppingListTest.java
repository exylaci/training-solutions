package week07.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingListTest {
    @Test
    public void calculateSumTest(){
        ShoppingList s = new ShoppingList();
        assertEquals(2750,
                s.calculateSum("C:\\training\\training-solutions\\src\\main\\resources\\week07\\d4\\ShoppingList.txt"));
    }

    @Test
    public void calculateSumWrongFileNameTest(){
        ShoppingList s = new ShoppingList();
        Exception exception = assertThrows( IllegalArgumentException.class , ()->
                 s.calculateSum("nemlétező.file"));
        assertEquals("Cant read this file: nemlétező.file" , exception.getMessage());
    }
}

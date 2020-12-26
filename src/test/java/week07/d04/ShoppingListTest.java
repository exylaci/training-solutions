package week07.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingListTest {
    @Test
    public void calculateSumTest() {
        ShoppingList s = new ShoppingList();
//        Path path = Path.of("ShoppingList.txt").toAbsolutePath();
//        -->  C:\training\training-solutions\ShoppingList.txt

//        Path path = Path.of(this.getClass().getResource("ShoppingList.txt").getPath().substring(1));
//        -->  C:\training\training-solutions\target\classes\week07\d04\ShoppingList.txt

        Path path = Path.of("src/main/resources").toAbsolutePath().
                resolve(this.getClass().getPackage().getName().replace('.', '/')).
                resolve("ShoppingList.txt");
//        -->  C:\training\training-solutions\src\main\resources\week07\d04\ShoppingList.txt

        assertEquals(2750,
                s.calculateSum(path.toString()));
    }

    @Test
    public void calculateSumWrongFileNameTest() {
        ShoppingList s = new ShoppingList();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                s.calculateSum("nemlétező.file"));
        assertEquals("Cant read this file: nemlétező.file", exception.getMessage());
    }
}

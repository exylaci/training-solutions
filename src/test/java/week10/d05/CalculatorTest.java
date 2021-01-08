package week10.d05;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static week10.d05.Calculator.findMinMaxSum;
import static week10.d05.Calculator.findMinSum;

public class CalculatorTest {
    @Test
    void findMinMaxSumTest() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psold = System.out;
        PrintStream psnew = new PrintStream(baos);
        System.setOut(psnew);

        findMinMaxSum(new int[]{});
        findMinMaxSum(new int[]{4});
        findMinMaxSum(new int[]{-4});
        findMinMaxSum(new int[]{1, 2, 3, 4});
        findMinMaxSum(new int[]{8, 9, 2, 5, 13, 222});
        findMinMaxSum(new int[]{-1, -2, -3, -4});
        findMinMaxSum(new int[]{8, 9, 2, 5, 13, -222});

        System.out.flush();
        System.setOut(psold);

        Scanner scanner = new Scanner(baos.toString());
        assertEquals(String.format("A legkissebbek összege: 0"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: 0"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: 4"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: 4"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: -4"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: -4"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: 10"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: 10"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: 24"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: 252"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: -10"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: -10"), scanner.nextLine());
        assertEquals(String.format("A legkissebbek összege: -207"), scanner.nextLine());
        assertEquals(String.format("A legnagyobbak összege: 35"), scanner.nextLine());
    }

    @Test
    void findMinMaxSumErrorTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                findMinMaxSum(null));
        assertEquals("Nem kaptam adatot!", exception.getMessage());
    }

    @Test
    void findMinSumTest() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psold = System.out;
        PrintStream psnew = new PrintStream(baos);
        System.setOut(psnew);

        findMinSum(new int[]{});
        findMinSum(new int[]{4});
        findMinSum(new int[]{-4});
        findMinSum(new int[]{1, 2, 3, 4});
        findMinSum(new int[]{8, 9, 2, 5, 13, 222});
        findMinSum(new int[]{-1, -2, -3, -4});
        findMinSum(new int[]{8, 9, 2, 5, 13, -222});

        System.out.flush();
        System.setOut(psold);

        Scanner scanner = new Scanner(baos.toString());
        assertEquals(String.format("A legkisebb számok összege: 0"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: 4"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: -4"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: 10"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: 24"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: -10"), scanner.nextLine());
        assertEquals(String.format("A legkisebb számok összege: -207"), scanner.nextLine());
    }

    @Test
    void findMinSumErrorTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                findMinSum(null));
        assertEquals("Nincs megadott adat!", exception.getMessage());
    }
}

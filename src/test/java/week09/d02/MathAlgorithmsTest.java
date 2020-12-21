package week09.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {
    @Test
    void smallestCommonMultipleTest() {
        int one=2*2*2*3*3*5;
        int two=2*2*3*3*3*7;
        int result = 2*2*2*3*3*3*5*7;
//        System.out.printf("%d és %d legkisebb közös többszöröse: %d\n",one,two,result);

        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two));
        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two, MathAlgorithms.Methodology.NAGYON_LASSU_MODSZER));
        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two, MathAlgorithms.Methodology.FAVAGO_MODSZER));
        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two, MathAlgorithms.Methodology.LAGNAGYOBB_KOZOS_OSZTO_MODSZERE));
        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two, MathAlgorithms.Methodology.TRUKKOS));
        assertEquals(result, MathAlgorithms.smallestCommonMultiple(
                one,two, MathAlgorithms.Methodology.PRIMTENYEZOS_FELBONTASSAL));

        assertEquals(1, MathAlgorithms.smallestCommonMultiple(
                1,1, MathAlgorithms.Methodology.NAGYON_LASSU_MODSZER));
        assertEquals(1, MathAlgorithms.smallestCommonMultiple(
                1,1, MathAlgorithms.Methodology.FAVAGO_MODSZER));
        assertEquals(1, MathAlgorithms.smallestCommonMultiple(
                1,1, MathAlgorithms.Methodology.LAGNAGYOBB_KOZOS_OSZTO_MODSZERE));
        assertEquals(1, MathAlgorithms.smallestCommonMultiple(
                1,1, MathAlgorithms.Methodology.TRUKKOS));
        assertEquals(1, MathAlgorithms.smallestCommonMultiple(
                1,1, MathAlgorithms.Methodology.PRIMTENYEZOS_FELBONTASSAL));

        assertEquals(2, MathAlgorithms.smallestCommonMultiple(
                1,2, MathAlgorithms.Methodology.NAGYON_LASSU_MODSZER));
        assertEquals(2, MathAlgorithms.smallestCommonMultiple(
                1,2, MathAlgorithms.Methodology.FAVAGO_MODSZER));
        assertEquals(2, MathAlgorithms.smallestCommonMultiple(
                1,2, MathAlgorithms.Methodology.LAGNAGYOBB_KOZOS_OSZTO_MODSZERE));
        assertEquals(2, MathAlgorithms.smallestCommonMultiple(
                1,2, MathAlgorithms.Methodology.TRUKKOS));
        assertEquals(2, MathAlgorithms.smallestCommonMultiple(
                1,2, MathAlgorithms.Methodology.PRIMTENYEZOS_FELBONTASSAL));

        assertEquals(4, MathAlgorithms.smallestCommonMultiple(
                2,4, MathAlgorithms.Methodology.NAGYON_LASSU_MODSZER));
        assertEquals(4, MathAlgorithms.smallestCommonMultiple(
                2,4, MathAlgorithms.Methodology.FAVAGO_MODSZER));
        assertEquals(4, MathAlgorithms.smallestCommonMultiple(
                2,4, MathAlgorithms.Methodology.LAGNAGYOBB_KOZOS_OSZTO_MODSZERE));
        assertEquals(4, MathAlgorithms.smallestCommonMultiple(
                2,4, MathAlgorithms.Methodology.TRUKKOS));
        assertEquals(4, MathAlgorithms.smallestCommonMultiple(
                2,4, MathAlgorithms.Methodology.PRIMTENYEZOS_FELBONTASSAL));
    }

    @Test
    void smallestCommonMultipleParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.smallestCommonMultiple(0, 1));
        exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.smallestCommonMultiple(1, 0));
        exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.smallestCommonMultiple(1, 1, null));
    }
}
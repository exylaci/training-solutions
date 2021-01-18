package week12.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsPackerTest {

    @Test
    void packGoodsTest() {
        GoodsPacker g = new GoodsPacker();

        assertEquals(555, g.packGoods(new int[][]{{7, 160}, {3, 90}, {2, 15}}, 20));
        assertEquals(1830, g.packGoods(new int[][]{{4, 399}, {6, 600}, {1, 15}}, 20));
        assertEquals(2005, g.packGoods(new int[][]{{6, 600}, {4, 401}, {1, 15}}, 20));
        assertEquals(1830, g.packGoods(new int[][]{{6, 600}, {4, 400}, {1, 15}}, 20));
        assertEquals(2000, g.packGoods(new int[][]{{4, 400}, {6, 600}, {1, 15}}, 20));
    }

    @Test
    void packGoodsParameterTest() {
        GoodsPacker g = new GoodsPacker();
        assertEquals(0, g.packGoods(null, 20));
    }
}
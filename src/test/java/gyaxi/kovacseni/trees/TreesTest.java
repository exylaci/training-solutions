package gyaxi.kovacseni.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreesTest {

    private Tree tree;

    @Test
    void testAppleTree() {
        tree = new AppleTree(100);

        Assertions.assertEquals(Fruit.APPLE, tree.getFruit());
        Assertions.assertEquals(900, tree.growLeaves(80));

        tree=new AppleTree(100);
        tree.ripenFruit(80);

        Assertions.assertEquals(18, tree.getWeightOfFruit());
        Assertions.assertEquals(4, tree.hostBirdNest());
    }

    @Test
    void testCherryTree() {
        tree = new CherryTree(200);

        Assertions.assertEquals(Fruit.CHERRY, tree.getFruit());
        Assertions.assertEquals(1800, tree.growLeaves(80));

        tree = new CherryTree(200);
        tree.ripenFruit(80);

        Assertions.assertEquals(60, tree.getWeightOfFruit());
        Assertions.assertEquals(9, tree.hostBirdNest());
    }

    @Test
    void testWalnutTree() {
        tree = new WalnutTree(300);

        Assertions.assertEquals(Fruit.WALNUT, tree.getFruit());
        Assertions.assertEquals(2700, tree.growLeaves(80));

        tree = new WalnutTree(300);
        tree.ripenFruit(80);

        Assertions.assertEquals(270, tree.getWeightOfFruit());
        Assertions.assertEquals(13, tree.hostBirdNest());
    }
}
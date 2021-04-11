package gyaxi.kovacseni.trees;

public class CherryTree extends Tree {
    private static final int LEAVES_COEFFICIENT = 20;
    private static final int FRUITS_COEFFICIENT = 30;

    public CherryTree(int i) {
        super(i);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        increaseNumberOfLeaves(numberOfSunnyDays * LEAVES_COEFFICIENT);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        increaseWeightOfFruits(growLeaves(numberOfSunnyDays) / FRUITS_COEFFICIENT);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.CHERRY;
    }
}
package gyaxi.kovacseni.trees;

public class WalnutTree extends Tree {
    private static final int LEAVES_COEFFICIENT = 30;
    private static final int FRUITS_COEFFICIENT = 10;

    public WalnutTree(int i) {
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
        return Fruit.WALNUT;
    }
}
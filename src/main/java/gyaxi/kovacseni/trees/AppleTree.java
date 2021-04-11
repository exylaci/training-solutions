package gyaxi.kovacseni.trees;

public class AppleTree extends Tree {
    private static final int LEAVES_COEFFICIENT = 10;
    private static final int FRUITS_COEFFICIENT = 50;

    public AppleTree(int i) {
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
        return Fruit.APPLE;
    }
}
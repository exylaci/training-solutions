package gyaxi.kovacseni.trees;

public abstract class Tree {
    private static final int NEST_COEFFICIENT = 200;
    private int leaves;
    private int weightOfFruit;

    protected Tree(int leaves) {
        this.leaves = leaves;
    }

    public int hostBirdNest() {
        return leaves / NEST_COEFFICIENT;
    }

    public abstract int growLeaves(int numberOfSunnyDays);

    public abstract void ripenFruit(int numberOfSunnyDays);

    public abstract Fruit getFruit();

    public int getLeaves() {
        return leaves;
    }

    public int getWeightOfFruit() {
        return weightOfFruit;
    }

    protected void increaseNumberOfLeaves(int pieces) {
        leaves += pieces;
    }

    protected void increaseWeightOfFruits(int amount) {
        weightOfFruit += amount;
    }
}
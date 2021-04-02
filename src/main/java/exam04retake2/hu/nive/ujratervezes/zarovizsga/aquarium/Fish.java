package exam04retake2.hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {
    private String name;
    private int weight;
    private String color;
    private boolean hasMemoryLoss;

    public Fish(String name, int weight, String color, boolean hasMemoryLoss) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.hasMemoryLoss = hasMemoryLoss;
    }

    public String status() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %b",
                name, weight, color, hasMemoryLoss);
    }

    public abstract void feed();

    protected void increaseWeight(int value) {
        weight += value;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return hasMemoryLoss;
    }
}

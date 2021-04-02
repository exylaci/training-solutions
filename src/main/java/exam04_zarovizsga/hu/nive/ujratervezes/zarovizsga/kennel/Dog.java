package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {
    private final String name;
    private int happines;

    public Dog(String name) {
        this.name = name;
    }

    public abstract void feed();

    public abstract void play(int hours);

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happines;
    }

    protected void increaseHappines(int value) {
        happines += value;
    }

}

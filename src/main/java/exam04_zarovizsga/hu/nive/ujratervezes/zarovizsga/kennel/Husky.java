package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {
    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHappines(4);
    }

    @Override
    public void play(int hours) {
        increaseHappines(hours * 3);
    }
}

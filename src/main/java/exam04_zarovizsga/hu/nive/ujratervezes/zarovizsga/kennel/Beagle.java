package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHappines(2);
    }

    @Override
    public void play(int hours) {
        increaseHappines(hours * 2);
    }
}

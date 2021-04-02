package exam04retake2.hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish {
    public Kong(String name, int weight, String color) {
        super(name, weight, color, false);
    }

    @Override
    public void feed() {
        increaseWeight(2);
    }
}

package exam04retake2.hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish {
    public Tang(String name, int weight, String color) {
        super(name, weight, color, true);
    }

    @Override
    public void feed() {
        increaseWeight(1);
    }
}

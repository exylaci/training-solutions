package exam04retake2.hu.nive.ujratervezes.zarovizsga.aquarium;

public class Clownfish extends Fish {

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color, false);
    }

    @Override
    public void feed() {
        increaseWeight(1);
    }
}

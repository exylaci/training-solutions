package gyaxi.orokles.airport;

public class Passenger extends Person {
    private String seat;

    public Passenger(String name, int age, String seat) {
        super(name, age);
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public Type getType() {
        return Type.PASSENGER;
    }
}
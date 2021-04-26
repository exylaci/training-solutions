package gyaxi.orokles.airport;

public class GroundStaff extends Person {
    private final String job;

    public GroundStaff(String name, Integer age, String job) {
        super(name, age);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public Type getType() {
        return Type.GROUND_SUPPORT_STAFF;
    }
}
package exam04retake.hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {
    private String address;
    private int area;
    private int level;

    public Office(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    @Override
    public int clean() {
        return area*level*100;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Type getType() {
        return Type.OFFICE;
    }
}

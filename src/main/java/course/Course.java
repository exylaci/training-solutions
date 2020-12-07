package course;

public class Course {
    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null || begin == null) throw new IllegalArgumentException("Null parameter.");
        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return begin + ": " + name;
    }
}
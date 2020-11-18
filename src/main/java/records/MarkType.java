package records;

public enum MarkType {
    A(5,"excellent"),
    B(4, "very good"),
    C(3,"improvment needed"),
    D(2,"close fail"),
    F(1,"fail");

    int value;
    String description;

    MarkType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return name();
    }
}
package ioprintwriter.talentshow;

public class Production {
    private final int id;
    private final String name;

    public Production(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
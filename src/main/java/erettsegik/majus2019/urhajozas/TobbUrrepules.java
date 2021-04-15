package erettsegik.majus2019.urhajozas;

public class TobbUrrepules {
    private final String name;
    private final int first;
    private final int last;

    public TobbUrrepules(String name, int first, int last) {
        this.name = name;
        this.first = first;
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }
}
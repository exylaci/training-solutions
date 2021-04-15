package erettsegik.majus2019.urhajozas;

public class UrhajosSzam {
    private final String name;
    private final int pieces;

    public UrhajosSzam(String name, int pieces) {
        this.name = name;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }

    public int getPieces() {
        return pieces;
    }
}

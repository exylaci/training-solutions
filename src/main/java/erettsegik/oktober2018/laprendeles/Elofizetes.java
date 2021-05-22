package erettsegik.oktober2018.laprendeles;

public class Elofizetes {
    private int eloid;
    private int lapid;

    public static Elofizetes parse(String all) {
        Elofizetes elofizetes = new Elofizetes();
        String[] parts = all.split("\t");
        elofizetes.eloid = Integer.parseInt(parts[0]);
        elofizetes.lapid = Integer.parseInt(parts[1]);
        return elofizetes;
    }

    public int getEloid() {
        return eloid;
    }

    public int getLapid() {
        return lapid;
    }
}
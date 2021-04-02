package erettsegik.oktober2019.forditoiroda;

public class Fordito {
    public static final String SEPARATOR = "\t";
    private int nyelvid;
    private int szemelyid;

    public static Fordito createFromString(String value) {
        String[] parts = value.split(SEPARATOR);
        if (parts.length != 2) {
            return null;
        }

        try {
            return new Fordito(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]));

        } catch (NumberFormatException e) {
            System.out.println("Hibás sor: " + value);
            return null;
        }
    }

    private Fordito(int nyelvid, int szemelyid) {
        this.nyelvid = nyelvid;
        this.szemelyid = szemelyid;
    }

    public int getNyelvid() {
        return nyelvid;
    }

    public int getSzemelyid() {
        return szemelyid;
    }
}

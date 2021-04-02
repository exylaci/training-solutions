package erettsegik.oktober2019.forditoiroda;

public class Documentum {

    public static final String SEPARATOR = "\t";
    private int id;
    private int terjedelem;
    private String szakterulet;
    private int nyelvId;
    private int munkaido;

    public static Documentum createFromString(String value) {
        String[] parts = value.split(SEPARATOR);
        if (parts.length != 5) {
            return null;
        }

        try {
            return new Documentum(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]));

        } catch (NumberFormatException e) {
            System.out.println("Hibás sor: " + value);
            return null;
        }
    }

    private Documentum(int id, int terjedelem, String szakterulet, int nyelvId, int munkaido) {
        this.id = id;
        this.terjedelem = terjedelem;
        this.szakterulet = szakterulet;
        this.nyelvId = nyelvId;
        this.munkaido = munkaido;
    }

    public int getId() {
        return id;
    }

    public int getTerjedelem() {
        return terjedelem;
    }

    public String getSzakterulet() {
        return szakterulet;
    }

    public int getNyelvId() {
        return nyelvId;
    }

    public int getMunkaido() {
        return munkaido;
    }
}
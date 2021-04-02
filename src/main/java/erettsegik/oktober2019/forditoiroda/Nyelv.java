package erettsegik.oktober2019.forditoiroda;

public class Nyelv {
    public static final String SEPARATOR = "\t";
    private int id;
    private String fnyelv;
    private String cnyelv;
    private int egysegar;

    public static Nyelv createFromString(String value) {
        String[] parts = value.split(SEPARATOR);
        if (parts.length != 4) {
            return null;
        }

        try {
            return new Nyelv(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]));

        } catch (NumberFormatException e) {
            System.out.println("Hibás sor: " + value);
            return null;
        }
    }

    private Nyelv(int id, String fnyelv, String cnyelv, int egysegar) {
        this.id = id;
        this.fnyelv = fnyelv;
        this.cnyelv = cnyelv;
        this.egysegar = egysegar;
    }

    public int getId() {
        return id;
    }

    public String getFnyelv() {
        return fnyelv;
    }

    public String getCnyelv() {
        return cnyelv;
    }

    public int getEgysegar() {
        return egysegar;
    }
}

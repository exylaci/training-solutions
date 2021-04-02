package erettsegik.oktober2019.forditoiroda;

public class Szemely {
    public static final String SEPARATOR = "\t";
    private int id;
    private String name;
    private boolean elerheto;


    public static Szemely createFromString(String value) {
        String[] parts = value.split(SEPARATOR);
        if (parts.length != 3) {
            return null;
        }

        try {
            return new Szemely(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2].equals("0"));

        } catch (NumberFormatException e) {
            System.out.println("Hibás sor: " + value);
            return null;
        }
    }

    private Szemely(int id, String name, boolean elerheto) {
        this.id = id;
        this.name = name;
        this.elerheto = elerheto;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isElerheto() {
        return elerheto;
    }
}

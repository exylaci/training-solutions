package erettsegik.majus2019.urhajozas;

public class Repules {
    private static final String SEPARATOR = "\t";
    private static final String INVALID_LINE = "Invalid line!";

    private final int urhajosId;
    private final int kuldetesId;

    private Repules(int urhajosId, int kuldetesId) {
        this.urhajosId = urhajosId;
        this.kuldetesId = kuldetesId;
    }

    public static Repules of(String all) {
        String[] parts = all.split(SEPARATOR);
        if (parts.length != 2) {
            throw new IllegalArgumentException(INVALID_LINE);
        }
        try {
            return new Repules(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LINE);
        }
    }

    public int getUrhajosId() {
        return urhajosId;
    }

    public int getKuldetesId() {
        return kuldetesId;
    }
}

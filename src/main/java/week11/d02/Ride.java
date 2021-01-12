package week11.d02;

public class Ride {
    public static final String SEPARATOR = " ";
    public static final String INVALID_DAY_ERROR = "Invalid day!";
    public static final String TRANSPORT_DATA_IS_A_MUST = "Transport data is a must!";
    public static final String INVALID_DATA_STRUCTURE_ERROR = "Invalid data structure!";
    public static final String INVALID_DATA_ERROR = "Invalid data!";

    private int day;
    private int transport;
    private int distance;

    public Ride(int day, int transport, int distance) {
        if (day < 1 || day > 7) throw new IllegalArgumentException(INVALID_DAY_ERROR);

        this.day = day;
        this.transport = transport;
        this.distance = distance;
    }

    public Ride(String value) {
        if (value == null) throw new IllegalArgumentException(TRANSPORT_DATA_IS_A_MUST);

        String[] parts = value.split(SEPARATOR);
        if (parts.length != 3) throw new IllegalArgumentException(INVALID_DATA_STRUCTURE_ERROR);

        day = tryParse(parts[0]);
        transport = tryParse(parts[1]);
        distance = tryParse(parts[2]);
    }

    private int tryParse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATA_ERROR);
        }
    }

    public int getDay() {
        return day;
    }

    public int getTransport() {
        return transport;
    }

    public int getDistance() {
        return distance;
    }
}
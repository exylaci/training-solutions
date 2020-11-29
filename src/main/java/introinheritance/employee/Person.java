package introinheritance.employee;

public class Person {
    public static final String ERROR_EMPTY_NAME = "Name is a must!";
    public static final String ERROR_EMPTY_ADDRESS = "Name is a must!";
    private String name;
    private String address;

    public Person(String name, String address) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
        this.name = name;
        migrate(address);
    }

    public void migrate(String newAddress) {
        if (isEmpty(newAddress)) {
            throw new IllegalArgumentException(ERROR_EMPTY_ADDRESS);
        }
        this.address = newAddress;
    }

    private boolean isEmpty(String string) {
        if (string == null || string.isBlank()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

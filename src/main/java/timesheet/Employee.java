package timesheet;

public final class Employee {
    public static final String SEPARATOR = " ";
    private final String firstname;
    private final String lastname;


    public String getName() {
        return firstname + " " + lastname;
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Employee(String fullname) {
        String[] parts = fullname.split(SEPARATOR);
        this.firstname = parts[0];
        this.lastname = parts[1];
    }

    @Override
    public String toString() {
        return firstname + ' ' + lastname;
    }
}
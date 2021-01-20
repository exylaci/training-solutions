package ioreadstring.names;

public class Human {
    private String lastName;
    private String firstName;

    public Human(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Human(String fullName) {
        if (fullName != null) {
            String[] split = fullName.split(" ");
            this.firstName = split[0];
            if (split.length > 0) {
                this.lastName = split[1];
            }
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
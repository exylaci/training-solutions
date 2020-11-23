package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if ( name==null || name.isBlank() ){
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if ( socialSecurityNumber.length()<9 ){
            throw new IllegalArgumentException("Year cannot be before 1900!");
        }
        if ( yearOfBirth<1900 ){
            throw new IllegalArgumentException("Year cannot be before 1900!");
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}

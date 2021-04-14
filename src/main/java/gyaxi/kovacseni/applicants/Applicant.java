package gyaxi.kovacseni.applicants;

import java.util.Objects;

public class Applicant {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final String skill;

    public Applicant(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        skill = null;
    }

    public Applicant(String firstName, String lastName, String skill) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skill = skill;
        phoneNumber = null;
        email = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(firstName, applicant.firstName) && Objects.equals(lastName, applicant.lastName) && Objects.equals(phoneNumber, applicant.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", skill='" + skill + '\'' +
                "}\n";
    }
}

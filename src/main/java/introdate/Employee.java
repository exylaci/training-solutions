package introdate;

import java.time.LocalDate;

public class Employee {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate beginEmployment;

    public Employee(int year, int month, int day, String name) {
    this.name = name;
    this.dateOfBirth = LocalDate.of(year,month,day);
    this.beginEmployment = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getBeginEmployment() {
        return beginEmployment;
    }

    public void setName(String name) {
        this.name = name;
    }
}

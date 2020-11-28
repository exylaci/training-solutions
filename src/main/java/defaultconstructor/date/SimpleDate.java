package defaultconstructor.date;

import java.time.LocalDate;

public class SimpleDate {
    public static final String ERROR_MESSAGE = "One or more given parameter cannot be applied!";
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (year < 1900 ||
                month < 1 || month > 12 ||
                day < 1 || day > LocalDate.of(year, month, 1).lengthOfMonth()) {
            throw new IllegalArgumentException(String.format(String.format(ERROR_MESSAGE+" %d, %d, %d", year, month, day)));
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

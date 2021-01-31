package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {
    public static final Locale LOCALE = new Locale("hu", "HU");

    private LocalDate birthDay;

    public DateOfBirth(String date) {
        this(date, "yyyy.MM.dd");
    }

    public DateOfBirth(String date, String pattern) {
        this(date, pattern, LOCALE);
    }

    public DateOfBirth(String date, String pattern, Locale locale) {
        if (date == null || date.isBlank()) throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        if (pattern == null || pattern.isBlank())
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        if (locale == null) throw new NullPointerException("Locale must not be null!");

    }

    public DateOfBirth(int year, int month, int day) {
        birthDay = LocalDate.of(year, month, day);
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isBlank())
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        return birthDay.format(DateTimeFormatter.ofPattern(pattern));
    }

    public String findDayOfWeek() {
        return birthDay.getDayOfWeek().name();
    }
    public boolean isWeekDay() {
        return birthDay.getDayOfWeek().getValue() < 6;
    }

    public boolean wasItALeapYear() {
       return birthDay.isLeapYear();
    }

    public String findBirthDayOfWeekLater(int year){
        return birthDay.withYear(year).getDayOfWeek().name();
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) throw new NullPointerException("Locale must not be null!");
        return birthDay.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate date) {
        if (locale == null) throw new NullPointerException("Locale must not be null!");
        if (date == null) throw new NullPointerException("Date must not be null!");
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public LocalDate getDateOfBirth() {
        return birthDay;
    }

    public int countDaysSinceBirth(LocalDate now) {
        if (now.isBefore(birthDay)) throw new IllegalStateException("Birthdate is in the future!");
        return (int) ChronoUnit.DAYS.between(birthDay, now);
    }

    public int countDaysBetween(DateOfBirth dateOfBirth) {
        if (dateOfBirth == null) throw new IllegalStateException("Must be not null!");
        return (int) ChronoUnit.DAYS.between(birthDay, dateOfBirth.getDateOfBirth());
    }
}
//Gyakorlati feladat - Születésnap
//
//Életünk nevezetes dátumairól (DateOfBirth osztály) szeretnénk speciális információkat kapni, mint például: a hét mely
// napján születtünk, eddig összesen hány napot éltünk, vagy a saját és barátunk/párunk születése között pontosan hány
// nap telt el. A dátumokat tetszőlegesen formázott String formájában is szeretnénk látni.
//
//Hibakezelés
//Üres pattern esetén dobjon IllegalArgumentException-t az adott metódus. A Locale nem lehet null. Ha rossz dátumot
// adtunk meg születési dátumként, a countDaysSinceBirth() metódus dobjon IllegalStateException-t
//
//Tippek
//Használd a ChronoUnit enumot arra, hogy kiszámold, hány nap van két dátum között! Szervezzük külön metódusba az
// azonos paraméterek ellenőrzését!
//
//Megjegyzés
//Érdemes a dokumentációban átnézni a LocalDate, LocalTime osztályok nyújtotta lehetőségeket!
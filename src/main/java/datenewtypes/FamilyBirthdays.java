package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class FamilyBirthdays {
    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = List.of(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int findMonth = date.get(ChronoField.MONTH_OF_YEAR);
        int findDay = date.get(ChronoField.DAY_OF_MONTH);

        for (LocalDate birthDay : birthdays) {

            if (findMonth == birthDay.getMonthValue() &&
                    findDay == birthDay.getDayOfMonth()) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int inThisYear = date.get(ChronoField.YEAR);
        LocalDate measureFromThisDate = LocalDate.of(
                inThisYear, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        long closest = 367;
        for (LocalDate birthDay : birthdays) {
            long distance;
            LocalDate checkedBrthday = birthDay.withYear(inThisYear);
            if (checkedBrthday.isBefore(measureFromThisDate)) {
                distance = ChronoUnit.DAYS.between(measureFromThisDate, birthDay.withYear(inThisYear + 1));
            } else {
                distance = ChronoUnit.DAYS.between(measureFromThisDate, checkedBrthday);
            }
            closest = Math.min(closest, distance);
        }
        return (int) closest;
    }
}
//Írj egy FamilyBirthdays osztályt, mely konstruktor paraméterül kap születésnapokat. Implementáld benne az
// isFamilyBirthday és nextFamilyBirthDay metódusokat, a tesztben szereplő method reference-ek alapján.
//
//A isFamilyBirthday visszaadja, hogy a paraméterként átadott dátum születésnap-e. A nextFamilyBirthDay metódus
// visszaadja, hány nap van a legközelebbi születésnapig.
//Implementáció
//
//Nézd meg LocalDate query() metódusát, hogy mit kap paraméterül. Használd a ChronoUnit osztályt annak meghatározására,
// hogy két dátum között hány nap telt el.
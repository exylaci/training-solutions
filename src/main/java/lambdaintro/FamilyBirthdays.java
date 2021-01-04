package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> dates;

    public FamilyBirthdays(LocalDate... dates) {
        this.dates = Arrays.asList(dates);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        for (LocalDate one : dates) {
            if (one.getMonthValue() == date.get(ChronoField.MONTH_OF_YEAR) &&
                    one.getDayOfMonth() == date.get(ChronoField.DAY_OF_MONTH)) {
                return true;
            }
        }
        return false;

    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int result = Integer.MAX_VALUE;
        int daisOfDate = LocalDate.of(
                date.get(ChronoField.YEAR),
                date.get(ChronoField.MONTH_OF_YEAR),
                date.get(ChronoField.DAY_OF_MONTH)).getDayOfYear();
        for (LocalDate one : dates) {
            int different = (LocalDate.of(date.get(ChronoField.YEAR), one.getMonthValue(), one.getDayOfMonth())
                    .getDayOfYear() - daisOfDate + 365) % 365;
            result = Math.min(result, different);
        }
        return result;
    }
}
//Írj egy FamilyBirthdays osztályt, mely konstruktor paraméterül kap születésnapokat.
//Implementáld benne az isFamilyBirthday és nextFamilyBirthDay metódusokat, a tesztben szereplő method reference-ek alapján.
//
// A isFamilyBirthday visszaadja, hogy a paraméterként átadott dátum születésnap-e.
// A nextFamilyBirthDay metódus visszaadja, hány nap van a legközelebbi születésnapig.
//
//Implementációs javaslat
//Nézd meg LocalDate query() metódusát, hogy mit kap paraméterül.
// Használd a ChronoUnit osztályt annak meghatározására, hogy két dátum között hány nap telt el.
package period;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pension {
    List<Period> periods = new ArrayList<>();

    Period fullyNormalized(Period period) {
        if (period == null) throw new IllegalArgumentException("Period is a must!");

        return period.plusMonths(period.getDays() / 30).withDays(period.getDays() % 30).normalized();
    }

    public void addEmploymentPeriod(Period period) {
        if (period == null) throw new IllegalArgumentException("Period is a must!");

        periods.add(fullyNormalized(period));
    }

    public Period sumEmploymentPeriods() {
        Period sum = Period.of(0, 0, 0);
        for (Period period : periods) {
            sum.plus(period);
        }
        return fullyNormalized(sum);
    }

    public Period modifyByDays(Period period, int days) {
        if (period == null) throw new IllegalArgumentException("Period is a must!");

        return fullyNormalized(period.plusDays(days));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) throw new IllegalArgumentException("Dates are must!");

        return fullyNormalized(Period.between(fromDate, toDate));
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (fromDate.isEmpty() || toDate.isEmpty() || pattern.isEmpty()) {
            throw new IllegalArgumentException("Dates and pattern are obligatory!");
        }

        return getPeriodBetweenDates(
                LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern)),
                LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern)));
    }

    public int calculateTotalDays(Period period) {
        if (period == null) throw new IllegalArgumentException("Period is a must!");

        return (int) period.toTotalMonths() * 30 + period.getDays();
    }

    boolean isEmpty(String value) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return false;
    }
}
//Nyugdíjszámításhoz szükségünk van egy olyan osztályra, amely segítségével összegezni tudjuk a nyugdíj jogosultságot
// adó időtartamokat, egy-egy dátum adta intervallumot módosítani tudunk (pl. jogosultságot nem szerző napokkal), és
// egyéb műveleteket is végezhetünk.
//
//Hibakezelés
//A Stringként megadott paraméterek nem lehetnek null vagy üres String értékek. Ezek esetében dobjon a rendszer
// IllegalArgumentException-t, a megfelelő tájékoztató szöveggel. A dátum paraméter nem lehet null érték, a megfelelő
// metódus dobjon NullPointerException-t.
//
//Megvalósítási javaslatok
//A Period objektum normalizálható, de ez csak az év és hónap mezők “átváltását” biztosítja. Készítsünk egy teljes
// mértékben normalizáló metódust, ami a nap és hónap értékek közötti konverziót is biztosítja 1 hónap = 30 nap
// átváltás mellett (Period fullyNormalized(Period period)).
//
//publikus metódusok:
////public void addEmploymentPeriod(Period period)
//public Period sumEmploymentPeriods()
//public Period modifyByDays(Period period, int days)
//public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate)
//public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern)
//public int calculateTotalDays(Period period)
//
//Tippek
////Ahol a visszatérési érték Period, mindig a teljes mértékben normalizált objektumot adjuk vissza!
// (Ennek létjogosultsága persze vitatható, de legyünk következetesek!) Nézzük át a dokumentációban a parszolható
// period String szerkezetét! A paraméter stringek vizsgálatához készítsünk egy boolean isEmpty(String str) metódust!
// Az összegyűjtött időtartamokat egy kollekcióban célszerű tárolni, és azt lehet szükség esetén összegezni.
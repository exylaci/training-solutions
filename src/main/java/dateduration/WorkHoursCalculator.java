package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class WorkHoursCalculator {

    Duration duration = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        this.duration = this.duration.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        this.duration = duration.plus(Duration.ofDays(days).plusHours(hours).plusMinutes(minutes));
    }

    public void addWorkTime(String durationString) {
        if (isEmpty(durationString)) throw new IllegalArgumentException("Parameter must not be empty!");

        try {
            this.duration = duration.plus(Duration.parse(durationString));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public int calculateWorkHours() {
        return (int) getWorkDuration().toHours();
    }

    public Duration getWorkDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("Days: %d, hours: %d, minutes: %d",
                duration.toDays(),
                duration.toHours() % 24,
                duration.toMinutes() % 60);
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
//Programozási munka során rögzíteni kívánjuk, hogy az egyes funkciók kidolgozására mennyi időt fordítottunk.
// Készítsünk egy WorkHoursCalculator osztályt, amely ezt megvalósítja, az egyes időtartamokat legyünk képesek
// többféleképpen is bevinni, a beviteleket a rendszer összegzi, és lekérdezhetjük Duration formájában, megjeleníthetjük
// String-ként valamint kiszámíthatjuk az összes ráfordított időt munkaórákban.
//Hibakezelés
//
//Parszolás esetén a String nem lehet üres. Ezt kivételkezeléssel biztosítsuk, null vagy üres String esetén dobjon
// IllegalArgumentException-t a megfelelő szöveggel. Hasonlóképpen, ha a String paraméter nem üres, de a parszolás
// mégsem hajtható végre, dobjon IllegalArgumentException-t a megfelelő szöveggel.
//
// Megvalósítási javaslatok
//A Duration objektum esetében a nap-óra-perc Stringgé alakításnál próbáljuk a Duration saját metódusait használni!
//
//publikus metódusok:
//  public void addWorkTime(Duration duration)
//  public void addWorkTime(int days, int hours, int minutes)
//  public void addWorkTime(String durationString)
//  public int calculateWorkHours()
//  public Duration getWorkDuration()
//  public String toString()
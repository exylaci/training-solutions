package zonedDateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    ZonedDateTime departure;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        if (isEmpty(dateString) || isEmpty(pattern) || locale == null || zone == null) {
            throw new IllegalArgumentException("Parameters cannot be empty or null!");
        }

        departure = ZonedDateTime.of(LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale)),
                zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        if (zone==null) throw new IllegalArgumentException("Zone is a must!");

        return departure.plusHours(flightHours).plusMinutes(flightMinutes)
                .withZoneSameLocal(zone);
    }

    public ZonedDateTime getDepartureDateTime() {
        return departure;
    }


    private boolean isEmpty(String value) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FlightInfo f = new FlightInfo("2021-02-22 10:30", "yyyy-MM-dd HH:mm", Locale.FRANCE, ZoneId.of("Europe/Budapest"));
        System.out.println(f.getDepartureDateTime());
        System.out.println(f.getArrivalDateTime(ZoneId.of("US/Central"), 2, 30));
    }
}
//Hosszabb repülőutat tervezünk, kontinenseken keresztül. Az indulás helyi ideje alapján akarjuk kiszámolni az érkezés
// pontos idejét a célállomáson, a repülőút időtartam alapján.
//
//Megvalósítási javaslatok
//A számítás az időzónákon kívül vegye figyelembe a téli-nyári időszámításból (DST) adódó eltéréseket is.
//
//publikus metódusok:
// public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone)
// public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes)
// public ZonedDateTime getDepartureDateTime()
//
//Hibakezelés
//Ha a String formájában megadott paraméterek üresek (null vagy üres String), dobjon IllegalArgumentException-t a megfelelő szöveggel. Ha a Locale értéke null, dobjon NullPointerException-t a megfelelő szöveggel
//Megjegyzések
//
//Történetesen az USA március közepén, Európa pedig március végén áll át. Ezért pl. egy március 14.-i indulás esetén az indulás és érkezés között óra szerint 19 óra van (az eltérő DST átállás miatt az időeltolódás a zónák között 8 óra), míg egy március 1.-i indulás esetén 20 óra van (az időeltolódás a zónák között 9 óra). Tessék kipróbálni!
//
//Tippek
//A pattern alapján végzett parszolást és az üres String ellenőrzést célszerű külön metódusokba szervezni.
package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {
    private LocalTime time;

    public Rendezvous(int hour, int minute) {
        this.time = LocalTime.of(hour, minute);
    }

    public Rendezvous(String time, String pattern) {
        checkTime(time);
        checkPattern(pattern);

        try {
            this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }

    }

    private void checkTime(String time) {
        if (time == null || time.isBlank()) throw new IllegalArgumentException("Illegal time string: " + time);
    }

    private void checkPattern(String pattern) {
        if (pattern == null || pattern.isBlank()) throw new IllegalArgumentException("Empty pattern string!");
    }

    public LocalTime getTime() {
        return time;
    }

    public int countMinutesLeft(LocalTime base) {
        if (base.isAfter(time)) throw new MissedOpportunityException("Too late!");
        return (int) ChronoUnit.MINUTES.between(base, time);
    }

    public String toString(String pattern) {
        checkPattern(pattern);
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public void pushLater(int hours, int minutes) {
        time = time.plusHours(hours).plusMinutes(minutes);
    }

    public void pullEarlier(int hours, int minutes) {
        time = time.minusHours(hours).minusMinutes(minutes);
    }
}
//Fontos találkozó előtt állunk, és nem akarjuk lekésni, ezért tudnunk kell, hány perc van addig. Azzal is számolunk,
// hogy az időpont módosulhat. Egy Rendezvous osztályt készítünk a funkciókhoz.
//
//Hibakezelés
////Üres pattern esetén dobjon IllegalArgumentException-t. Hasonlóképpen a sikertelen parszolás is dobjon
// IllegalArgumentException-t. Ha elfeledkezünk az időpontról és már késő elmenni, a countMinutesLeft() metódus dobjon
// MissedOpportunityException-t. Ezt nekünk kell megírni, ez is egy RuntimeException.
//
//Tippek
////Használd a ChronoUnit enumot arra, hogy kiszámold, hány perc van két idő között!
//
//Szervezzük külön metódusba a paraméterek ellenőrzését!
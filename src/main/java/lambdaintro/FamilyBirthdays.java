package lambdaintro;

import java.time.LocalDate;
import java.time.Month;
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
      for (LocalDate one : dates){
//          if ( one.getMonth()==5){
//              return true;
//          }
      }
      return   false;

    }

    public int nextFamilyBirthDay(TemporalAccessor  date) {
        return -1;
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
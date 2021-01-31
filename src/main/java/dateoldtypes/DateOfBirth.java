package dateoldtypes;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {

    public static final String ILLEGAL_PATTERN = "Illegal pattern string, cannot use: ";
    public static final String ILLEGAL_DATE = "Illegal date string, cannot parse: ";
    public static final String ILLEGAL_LOCALE = "Locale must not be null!";
    private Date birthDay;

    public DateOfBirth(int year, int month, int day) {
        Calendar temp = Calendar.getInstance();
        temp.setLenient(false);
        temp.set(year, month - 1, day);
        birthDay = temp.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException(ILLEGAL_PATTERN);
        }
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException(ILLEGAL_DATE);
        }
        if (locale == null) {
            throw new NullPointerException(ILLEGAL_LOCALE);
        }
        DateFormat format = new SimpleDateFormat(pattern, locale);
        try {
            birthDay = format.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(ILLEGAL_DATE);
        }
    }

    public DateOfBirth(String dateString, String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException(ILLEGAL_PATTERN);
        }
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException(ILLEGAL_DATE);
        }

        DateFormat format = new SimpleDateFormat(pattern);
        try {
            birthDay = format.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(ILLEGAL_DATE);
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) throw new NullPointerException(ILLEGAL_LOCALE);

        Calendar temp = Calendar.getInstance();
        temp.setTime(birthDay);
        return temp.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) throw new IllegalArgumentException(ILLEGAL_PATTERN);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(birthDay);
    }

    public boolean isWeekDay() {
        return false;
    }

    private boolean isEmpty(String value) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return false;
    }
}
//Egy olyan osztályt akarunk létrehozni, amely életünk nevezetes dátumaival kapcsolatos extra információkat szolgáltat.
// Például meg tudja mondani, a hét melyik napján születtünk, vagy akár csak azt, hogy a nevezetes dátum hétköznapra
// vagy hétvégére esett. :)
//
//Hibakezelés
//Biztosítsuk a teszteseteknek megfelelően, hogy illegális év, hónap és nap paraméter értékek esetén, valamint hiányos
// dátum és formázó string paraméterek esetén dobjon IllegalArgumentException kivételt a megfelelő tájékoztató
// szöveggel, illetve null paraméter esetén dobjon NullPointerException-t, szintén a megfelelő szöveggel.
//
//Megvalósítási javaslatok
//Az osztály objektumait többféle módon is létre lehessen hozni. Figyeljünk a lenient flag beállítására!
//
//publikus metódusok:
//public DateOfBirth(int year, int month, int day)
//public DateOfBirth(String dateString, String pattern, Locale locale)
//public DateOfBirth(String dateString, String pattern)
//public String findDayOfWeekForBirthDate(Locale locale)
//public String toString(String pattern)
//public boolean isWeekDay()
//
//Tippek
//A paraméter string ellenőrzésére készüljön külön metódus, amit többször is fel tudunk használni. Hasonlóképpen a
// konstrukció során többször használandó közös utasításokat szervezzük ki külön metódusba.
//  boolean isEmpty(String str)
//  void setDateOfBirth(String dateString, DateFormat dateFormat)
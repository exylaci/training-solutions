package zonedDateTime;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class WorkHoursCalculator {
    private ZonedDateTime start;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        start = ZonedDateTime.of(startYear, startMonth.getValue(), startDay, startHour, 0, 0, 0, zone);
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        return ChronoUnit.HOURS.between(start, ZonedDateTime.of(
                year, month.getValue(), day, hour, 0, 0, 0, start.getZone()));
    }

    public ZonedDateTime getStartDateTime() {
        return start;
    }

    public static void main(String[] args) {
        WorkHoursCalculator whc = new WorkHoursCalculator(
                2021,Month.MARCH,1,0,ZoneId.of("Europe/Budapest"));
        System.out.println(whc.getStartDateTime());
        System.out.println(whc.calculateHours(2021,Month.APRIL,1,0));

         whc = new WorkHoursCalculator(
                2021,Month.JULY,1,0,ZoneId.of("Europe/Budapest"));
        System.out.println(whc.getStartDateTime());
        System.out.println(whc.calculateHours(2021,Month.AUGUST,1,0));
    }
}
//Ki kell számítanunk a pontos, órákban kifejezett időtartamot egy folyamatos (éjjel-nappali) munka dátum szerinti
// megkezdése és befejezése között.
//
//Megvalósítási javaslatok
//publikus metódusok:
//   public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone)
//   public long calculateHours(int year, Month month, int day, int hour)
//   public ZonedDateTime getStartDateTime()
//
//Megjegyzések
//Mivel a munka kezdeti és végdátuma közé eshet a tavaszi vagy őszi óraátállítás, ezt is vegyük figyelembe!
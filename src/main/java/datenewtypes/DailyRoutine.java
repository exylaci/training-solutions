package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DailyRoutine {
    private LocalTime startAt;

    public DailyRoutine(int hour, int minute) {
        this.startAt = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String time) {
        this.startAt = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:M"));
    }


    private LocalTime getStartTime() {
        return startAt;
    }

    private void setFutureTime(int i) {
        startAt = startAt.plusMinutes(i);
    }

    private boolean isBeforeNoon() {
        return startAt.isBefore(LocalTime.NOON);
    }

    public static void main(String[] args) {

        DailyRoutine dr = new DailyRoutine(9, 0);
        System.out.println(dr.getStartTime());
        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        System.out.println(dailyRoutine.getStartTime());
        dr.setFutureTime(3 * 45 + 20);
        System.out.println(dr.getStartTime());
        System.out.println(dr.isBeforeNoon());
    }
}

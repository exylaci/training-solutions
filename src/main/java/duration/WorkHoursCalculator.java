package duration;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {

    List<Duration> durations = new ArrayList<>();

    public void addWorkTime(Duration duration) {
        durations.add(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        durations.add(Duration.ofDays(days).plusHours(hours).plusMinutes(minutes));
    }

    public void addWorkTime(String durationString) {
        if (isEmpty(durationString)) throw new IllegalArgumentException("Duration is a must!");

        try {
            durations.add(Duration.parse(durationString));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Cannot convert to Period: " + e);
        }
    }

    public int calculateWorkHours() {
        return (int) getWorkDuration().toHours();
    }

    public Duration getWorkDuration() {
        Duration sum = Duration.ZERO;
        for (Duration duration : durations) {
            sum = sum.plus(duration);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Durations[" + durations + ']';
    }

    private boolean isEmpty(String value) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return false;
    }
}

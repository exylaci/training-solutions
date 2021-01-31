package period;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pension {
    List<Period> periods = new ArrayList<>();

    Period fullyNormalized(Period period) {
        return period.plusMonths(period.getDays() / 30).withDays(period.getDays() % 30).normalized();
    }

    public void addEmploymentPeriod(Period period) {
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
        return fullyNormalized(period.plusDays(days));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return fullyNormalized(Period.between(fromDate, toDate));
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        return getPeriodBetweenDates(
                LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern)),
                LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern)));
    }

    public int calculateTotalDays(Period period) {
        return (int) period.toTotalMonths() * 30 + period.getDays();
    }

    boolean isEmpty(String value) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return false;
    }
}


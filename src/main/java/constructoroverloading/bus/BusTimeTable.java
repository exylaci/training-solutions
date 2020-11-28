package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    public static final String ERROR_MESSAGE_NULL = "Time cannot be null!";
    public static final String ERROR_MESSAGE_RANGE = "This isn't a valid time!";
    public static final String ERROR_MESSAGE_NOMORE = "No more buses today!";
    public static final String ERROR_MESSAGE_EMPTY = "There is no bus at all";

    private List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        if (timeTable == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
        }
        this.timeTable = new ArrayList<>(timeTable);
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        if (firstHour < 0 || firstHour > 23 ||
                lastHour < 0 || lastHour > 23 ||
                everyMinute < 0 || everyMinute > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
        timeTable = new ArrayList<>();
        for (int hour = firstHour; hour <= lastHour; ++hour) {
            timeTable.add(new SimpleTime(hour, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable() {
        return new ArrayList<>(timeTable);
    }

    public SimpleTime nextBus(SimpleTime actual) {
        if (actual == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
        }
        for (SimpleTime one : timeTable) {
            if (one.difference(actual) >= 0) {
                return one;
            }
        }
        throw new IllegalStateException(ERROR_MESSAGE_NOMORE);
    }

    public SimpleTime firstBus() {
        SimpleTime first = null;
        SimpleTime zero = new SimpleTime(0, 0);
        int closest = -1441;

        for (SimpleTime one : timeTable) {
            int distance = zero.difference(one);
            if (distance > closest) {
                closest = distance;
                first = one;
            }
        }
        if (closest > -1441) {
            return first;
        }
        throw new IllegalStateException(ERROR_MESSAGE_EMPTY);
    }
}

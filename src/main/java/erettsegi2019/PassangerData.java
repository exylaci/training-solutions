package erettsegi2019;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class PassangerData {
    private int stop;
    private LocalDateTime time;
    private String ID;
    private Type type;
    private LocalDate expires;
    private int remainedTravels;

    public PassangerData(int stop, LocalDateTime time, String ID, Type type, LocalDate expires) {
        this.stop = stop;
        this.time = time;
        this.ID = ID;
        this.type = type;
        this.expires = expires;
    }

    public PassangerData(int stop, LocalDateTime time, String ID, Type type, int remainedTravels) {
        this.stop = stop;
        this.time = time;
        this.ID = ID;
        this.type = type;
        this.remainedTravels = remainedTravels;
    }

    public int getStop() {
        return stop;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getID() {
        return ID;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public int getRemainedTravels() {
        return remainedTravels;
    }

    @Override
    public String toString() {
        return "PassangerData{" +
                "stop=" + stop +
                ", time=" + time +
                ", ID='" + ID + '\'' +
                ", type=" + type +
                ", expires=" + expires +
                ", remainedTravels=" + remainedTravels +
                '}';
//        return String.format(new Locale("hu","HU"),"%2d. %tc %s %s %tc %d",
//                stop, time , ID, type.toString() , expires ,remainedTravels );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassangerData that = (PassangerData) o;
        return stop == that.stop &&
                remainedTravels == that.remainedTravels
                && time.equals(that.time) &&
                ID.equals(that.ID) &&
                type == that.type &&
                expires.equals(that.expires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stop, time, ID, type, expires, remainedTravels);
    }
}

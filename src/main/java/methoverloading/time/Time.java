package methoverloading.time;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this(hours, minutes);
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public boolean isEqual(Time time) {
        return isEqual(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        if (this.hours == hours &&
                this.minutes == minutes &&
                this.seconds == seconds) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(Time time) {
        return isEarlier(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        if (this.hours < hours) {
            return true;
        } else if (this.hours > hours) {
            return false;
        } else if (this.minutes < minutes) {
            return true;
        } else if (this.minutes > minutes) {
            return false;
        } else if (this.seconds < seconds) {
            return true;
        }
        return false;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

package enumtype.week;

public enum Day {
        MONDAY(DayType.WORKDAY),
        TUESDAY(DayType.WORKDAY),
        WEDNESDAY(DayType.WORKDAY),
        THURSDAY(DayType.WORKDAY),
        FRIDAY(DayType.WORKDAY),
        SATURDAY(DayType.HOLIDAY),
        SUNDAY(DayType.HOLIDAY);
    private final DayType dayType;

    Day(DayType dayType) {
        this.dayType = dayType;
    }

    public DayType getDayType() {
        return dayType;
    }

    public Day nextDay(){                       //bonusz feladatban itt van ez a metódus
        return Day.values()[ (ordinal()+1) % Day.values().length ];
    }
}

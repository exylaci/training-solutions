package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> dayTypes = new ArrayList<>();
        do {
            dayTypes.add(firstDay.getDayType());
//            firstDay=nextDay(firstDay);           //bonusz feladat nélkül ez a sor
            firstDay=firstDay.nextDay();            //bonusz feladatban ez a sor
            --numberOfDays;
        }while (numberOfDays>0);
        return dayTypes;
    }

    private Day nextDay(Day day){                   //bonusz feladat nélkül ez a metódus
        return Day.values()[ (day.ordinal()+1) % Day.values().length ];

    }

}

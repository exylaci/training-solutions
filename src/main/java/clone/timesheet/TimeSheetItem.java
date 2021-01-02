package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        this.employee = timeSheetItem.employee;
        this.project = timeSheetItem.project;
        this.from = timeSheetItem.from;
        this.to = timeSheetItem.to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate newDate) {
        TimeSheetItem result = new TimeSheetItem(timeSheetItem);
        result.from = result.changeDate(result.getFrom(), newDate);
        result.to = result.changeDate(result.getTo(), newDate);
        return result;
    }

    private LocalDateTime changeDate(LocalDateTime old, LocalDate newDate) {
        return LocalDateTime.of(newDate.getYear(), newDate.getMonth(), newDate.getDayOfMonth(), old.getHour(), old.getMinute());
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
//A clone.timesheet.TimeSheetItem osztály tartalmazza, hogy egy alkalmazott mikor, min dolgozott.
// Van egy employee, project, from és egy to attribútuma.
//
// Legyen egy konstruktora, mely ezekkel az adatokkal inicializálja.
// Azonban legyen egy copy konstruktora is,
//  mely paraméterül kap egy TimeSheetItem példányt, és annak adatait átmásolja az új példányba.
//
// Legyen egy statikus withDifferentDay(TimeSheetItem, LocalDate) metódusa is,
//  mely lemásolja a paraméterként átadott bejegyzést,
//  azonban a from és to attribútumokban szereplő dátumokat kicseréli a másodikként megadott napra,
//  de az időket érintetlenül hagyja. Ez a statikus metódus hívja a copy konstruktort.
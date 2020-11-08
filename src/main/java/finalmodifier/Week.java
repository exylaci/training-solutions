package finalmodifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Week {
    public final List<String> daysOfWeek = Arrays.asList("Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap");
    //public final int j;   // kell neki értéket adni.

    public static <i> void main(String[] args) {
        Week week = new Week();
        System.out.println(week.daysOfWeek);

        week.daysOfWeek.set( week.daysOfWeek.indexOf("Kedd") ,"Szerda");
        System.out.println(week.daysOfWeek);

        List<String> otherList = Arrays.asList("Egy","Kettő");
        // week.daysOfWeek = otherList;      // final-nak nem lehet újra értéket adni

        System.out.println("\n\rBonusz 1.");
        final int i;
        i=1;        //valmikor (első felhasználás előtt) kell neki értéket adni
        // i=2;     //csak egyszer lehet értéket adni
        System.out.println(i);
    }
}

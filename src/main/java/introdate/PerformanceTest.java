package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {

        Performance performance = new Performance(
                LocalDate.of(1986,6,2),
                "Queen",
                LocalTime.of(18,0) ,
                LocalTime.of(20,0) );

        System.out.println("név:"+performance.getArtist());
        System.out.println("nap:"+performance.getDate());
        System.out.println("kezdés:"+performance.getStartTime());
        System.out.println("vége:"+performance.getEndTime());
        System.out.println(performance.getInfo());
    }
}

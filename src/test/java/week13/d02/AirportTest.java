package week13.d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void loadScheduleTest() {
        Airport a = new Airport();
        a.loadSchedule(Path.of("src/main/resources/week13/d02/cities.txt"));

        assertEquals(100,a.getPlanes().size());
//        System.out.println(a.getPlanes());
    }

    @Test
    void getMoreDirectionTest() {
        Airport a = new Airport();
        a.loadSchedule(Path.of("src/main/resources/week13/d02/cities.txt"));

        assertEquals(Direction.DEPARTURE,a.getMoreDirection());
    }

    @Test
    void getPlaneByIDTest() {
        Airport a = new Airport();
        a.loadSchedule(Path.of("src/main/resources/week13/d02/cities.txt"));

        assertEquals("Toronto",a.getPlaneByID("EJ9251").getCity());
    }

    @Test
    void collectPlanesByCityTest() {
        Airport a = new Airport();
        a.loadSchedule(Path.of("src/main/resources/week13/d02/cities.txt"));

        List<Plane> result =   a.collectPlanesByCity(new Scanner("Toronto\n2\n"));

        assertEquals(3,result.size());
        assertEquals("CG5502",result.get(1).getID());
    }

    @Test
    void getEarliestDepartureTest() {
        Airport a = new Airport();
        a.loadSchedule(Path.of("src/main/resources/week13/d02/cities.txt"));

        assertEquals("FG3210",a.getEarliestDeparture().getID());
    }
}
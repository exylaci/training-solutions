package gyaxi.orokles.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    static List<Person> people;

    @BeforeEach
    void init() {
        people = List.of(
                new Stewardess("Jucika", Position.TEAM_LEADER),
                new Stewardess("Sebi", 19, Position.SUBORDINATE),
                new GroundStaff("Szaki bá", 47, "műszerész"),
                new GroundStaff("marika néni", 53, "takarító"),
                new Passenger("Juci", 49, "3A"),
                new Passenger("Béla", 55, "3B"),
                new Passenger("Diána", 59, "3C"),
                new Passenger("János", 69, "3D"),
                new Passenger("Sámuel", 21, "3E"),
                new Passenger("Sanyi", 27, "3F"),
                new Passenger("Józsi", 29, "4F"),
                new Passenger("Éva", 39, "17F"),
                new Passenger("Ferenc", 79, "17A"),
                new Passenger("Zénó", 89, "4E"),
                new Pilot("Scott", 39, Position.CAPTAIN),
                new Pilot("Morse", 79, Position.RADIO_OPERATOR),
                new Pilot("Montgolfier", 49, Position.SECOND_OFFICER));
    }

    @Test
    void constructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Plane(null));
        assertEquals("Person list is a must!", exception.getMessage());
    }

    @Test
    void getCabinCrew() {
        Set<Stewardess> result = new Plane(people).getCabinCrew();

        assertEquals(2, result.size());
        assertTrue(result.contains(new Stewardess("Jucika", Position.TEAM_LEADER)));
        assertFalse(result.contains(new Stewardess("Jucika", Position.SUBORDINATE)));
        assertTrue(result.contains(new Stewardess("Sebi", Position.SUBORDINATE)));
    }

    @Test
    void relocate() {
        Plane plane = new Plane(people);

        plane.relocate();
        List<Person> result = plane.getPepople();

        assertEquals(17, result.size());
        assertEquals("3C", ((Passenger) result.get(4)).getSeat());
        assertEquals("3B", ((Passenger) result.get(5)).getSeat());
        assertEquals("3A", ((Passenger) result.get(6)).getSeat());
        assertEquals("3F", ((Passenger) result.get(7)).getSeat());
        assertEquals("3E", ((Passenger) result.get(8)).getSeat());
        assertEquals("3D", ((Passenger) result.get(9)).getSeat());
        assertEquals("17C", ((Passenger) result.get(12)).getSeat());
    }

    @Test
    void findTheOldest1() {
        assertEquals("marika néni", new Plane(people).findTheOldest());
    }

    @Test
    void findTheOldest2() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Plane(List.of()).findTheOldest());
        assertEquals("The plane is empty!", exception.getMessage());
    }

    @Test
    void findTheYoungest1() {
        assertEquals("Sebi", new Plane(people).findTheYoungest());
    }

    @Test
    void findTheYoungest2() {
        List<Person> people = List.of(
                new Stewardess("Jucika", Position.TEAM_LEADER),
                new GroundStaff("Szaki bá", 17, "műszerész"),
                new Passenger("Zénó", 29, "4E"),
                new Pilot("Ikarosz", 20, Position.SECOND_OFFICER));
        assertEquals("Ikarosz", new Plane(people).findTheYoungest());
    }

    @Test
    void findTheYoungest3() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Plane(List.of()).findTheYoungest());
        assertEquals("The plane is empty!", exception.getMessage());
    }

    @Test
    void findTheCaptain1() {
        assertEquals("Scott", new Plane(people).findTheCatain().getName());
    }

    @Test
    void findTheCaptain2() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Plane(List.of()).findTheCatain());
        assertEquals("The plane is empty!", exception.getMessage());
    }

    @Test
    void passangerList() {
        Map<String, Passenger> result = new Plane(people).getPassangerList();

        assertEquals(10, result.size());
        assertEquals("Sanyi", result.get("3F").getName());
        assertEquals("Juci", result.get("3A").getName());
        assertEquals("Diána", result.get("3C").getName());
        assertEquals("János", result.get("3D").getName());
    }

    @Test
    void newYearsEve() {
        Plane plane = new Plane(people);

        plane.newYearsEve();
        List<Person> result = plane.getPepople();

        assertNull(result.get(0).getAge());
        assertEquals(20, result.get(1).getAge());
        assertEquals(54, result.get(3).getAge());
        assertEquals(50, result.get(16).getAge());
    }

    @Test
    void beforeTakeOff() {
        Plane plane = new Plane(people);

        plane.beforeTakeOff();
        List<Person> result = plane.getPepople();

        assertEquals(15, result.size());
        assertEquals("Juci", result.get(2).getName());
        assertEquals("Béla", result.get(3).getName());
        assertEquals("Montgolfier", result.get(14).getName());
    }

    @Test
    void howOldTheCaptain() {
        assertEquals(39, new Plane(people).howOldTheCatain().get());
        assertEquals(Optional.empty(), new Plane(List.of()).howOldTheCatain());
    }
}
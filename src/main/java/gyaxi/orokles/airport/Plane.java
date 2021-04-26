package gyaxi.orokles.airport;

import java.util.*;
import java.util.stream.Collectors;

public class Plane {
    public static final String ERROR_EMPTY = "The plane is empty!";

    private List<Person> people;

    public Plane(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException("Person list is a must!");
        }
        this.people = new ArrayList<>(people);
    }

    public List<Person> getPepople() {
        return Collections.unmodifiableList(people);
    }

    public Set<Stewardess> getCabinCrew() {
        return people.stream()
                .filter(person -> person.getType() == Type.STEWARDESS)
                .map(person -> ((Stewardess) person))
                .collect(Collectors.toSet());
    }

    public void relocate() {
        for (Person person : people) {
            if (person.getType() == Type.PASSENGER) {
                move(person);
            }
        }
    }

    private void move(Person person) {
        Passenger passenger = (Passenger) person;
        String seat = passenger.getSeat();
        char originalColumn = seat.charAt(seat.length() - 1);
        char newColumn = switch (originalColumn) {
            case 'A' -> 'C';
            case 'C' -> 'A';
            case 'D' -> 'F';
            case 'F' -> 'D';
            default -> originalColumn;
        };
        seat = seat.replace(originalColumn, newColumn);
        passenger.setSeat(seat);
    }

    public String findTheOldest() {
        return people.stream()
                .filter(person -> !person.getType().isTravel())
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalStateException(ERROR_EMPTY))
                .getName();
    }

    public String findTheYoungest() {
        return people.stream()
                .filter(person -> person.getType().isTravel())
                .filter(person -> person.getAge() != null)
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalStateException(ERROR_EMPTY))
                .getName();
    }

    public Pilot findTheCatain() {
        return people.stream()
                .filter(person -> person.getType() == Type.PILOT)
                .map(person -> ((Pilot) person))
                .filter(pilot -> pilot.getPosition() == Position.CAPTAIN)
                .findAny()
                .orElseThrow(() -> new IllegalStateException(ERROR_EMPTY));
    }

    public Map<String, Passenger> getPassangerList() {
        Map<String, Passenger> passengers = new HashMap<>();

        people.stream()
                .filter(person -> person.getType() == Type.PASSENGER)
                .forEach(person -> passengers.put(((Passenger) person).getSeat(), ((Passenger) person)));

        return passengers;
    }

    public void newYearsEve() {
        people.stream().filter(person -> person.getAge() != null).forEach(Person::becomeOlder);
    }

    public void beforeTakeOff() {

//        people.removeIf(person -> !person.getType().isTravel());

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getType().isTravel()) {
                iterator.remove();
            }
        }

//        people = people.stream().filter(person -> person.getType().isTravel()).collect(Collectors.toList());
    }

    public Optional<Integer> howOldTheCatain() {
        return people.stream()
                .filter(person -> person.getType() == Type.PILOT)
                .filter(person -> ((Pilot) person).getPosition() == Position.CAPTAIN)
                .map(Person::getAge)
                .findAny();
    }
}
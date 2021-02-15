package week16.d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CanoeOffice {
    private List<CanoeRental> rentals = new ArrayList<>();

    public void addRental(CanoeRental canoue) {
        rentals.add(canoue);
    }

    public CanoeRental findRentalByName(String name) {
        for (CanoeRental canoe : rentals) {
            if (canoe.getName().equals(name) && canoe.isActive()) {
                return canoe;
            }
        }
        throw new IllegalArgumentException("Can't find " + name);
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        findRentalByName(name).setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental canoe = findRentalByName(name);

        Duration duration = Duration.between(canoe.getStartTime(), endTime);
        double length = duration.toHours();
        if (duration.get(ChronoUnit.MINUTES) > 0) {
            ++length;
        }
        length *= canoe.getCanoeType().getValue();

        return length;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> result = new ArrayList<>();
        for (CanoeRental canoe : rentals) {
            if (!canoe.isActive()) {
                result.add(canoe);
            }
        }
        result.sort(Comparator.comparing(CanoeRental::getStartTime));
        return result;
    }

    public Map<CanoeType, Long> countRentals() {
        return rentals
                .stream()
                .collect(Collectors.groupingBy(CanoeRental::getCanoeType, Collectors.counting()));
    }
}
//* addRental(CanoeRental) - hozzáad egy kölcsönzést
//* findRentalByName(String name) - megkeres egy AKTÍV kölcsönzést név alapján
//* closeRentalByName(String name, LocalDateTime endTime) - megkeres egy AKTÍV kölcsönzést név alapján, beállítja az endTime értékét
//* double getRentalPriceByName(String name, LocalDateTime endTime) - kikeresi az AKTÍV kölcsönzést név alapján, és kiszámolja, hogy
//a megadott kölcsönzés mennyibe kerülne. A számolás úgy történik, hogy óránként 5000 Ft-ot a szín alapján megszoroz egy értékkel, piros,
//zöld és kék esetén rendre 1, 1,2 és 1,5 értékkel. Minden megkezdett óra számít.
//* List<CanoeRental> listClosedRentals() - Add vissza a lezárt kölcsönzéseket a startTime alapján sorbarendezve!
//* Map<CanoeType, Integer> countRentals() - Számold meg, hány kölcsönzés volt színenként! (edited)

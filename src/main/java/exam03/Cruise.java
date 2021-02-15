package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
            return;
        }
        throw new IllegalArgumentException("Full house!");
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getPriceMultiplier();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("Cant find!");
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers
                .stream()
                .map(Passenger::getName)
                .sorted(Collator.getInstance(new Locale("hu", "HU")))
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers
                .stream()
                .mapToDouble(this::getPriceForPassenger)
                .sum();
    }

    public Map<CruiseClass, Long> countPassengerByClass() {
        return Collections.unmodifiableMap(
                passengers
                        .stream()
                        .collect(Collectors.groupingBy(
                                Passenger::getCruiseClass,
                                Collectors.counting())));
    }
}
//Utazási iroda hajóutakat szervez. Minden hajóút egy adott hajóval történik, amelynek neve és befogadóképessége a egy
//Boat osztályban van tárolva.
//
//Az utasok adott hajóra, adott osztályra foglalnak helyet. A helyfoglaláskor azonban ellenőrizni kell, hogy a
//befogadóképesség alapján van-e még hely. Ha nincs, egy kivételt várunk a megfelelő szöveggel. A CruiseClass enum
//tárolja a különböző osztályokat. LUXURY, FIRST és SECOND osztályok vannak. Az ár számolása úgy történik, hogy venni
//kell a hajóhoz tartozó alapárat, és meg kell szorozni az osztályhoz tartozó szorzóval, rendre 3,0, 1,8 és 1,0.
//
//UML
//
//    bookPassenger(): egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
//    getPriceForPassenger(): visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
//    findPassengerByName(): foglalás megkeresése név alapján
//    getPassengerNamesOrdered(): visszaadja a foglalást végzők neveit ábécé sorrendben
//    sumAllBookingsCharged(): összegzi, hogy mennyi az összes bevétel
//    countPassengerByClass(): visszaadja, hogy osztályonként mennyien foglaltak
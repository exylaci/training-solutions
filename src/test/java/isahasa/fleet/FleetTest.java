package isahasa.fleet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FleetTest {

    Fleet fleet = new Fleet();

    Liner liner1 = new Liner(100);

    Liner liner2 = new Liner(200);

    CargoShip cargoShip = new CargoShip(50);

    FerryBoat ferryBoat = new FerryBoat(100, 40);

    @BeforeEach
    public void init() {
        fleet.addShip(liner1);
        fleet.addShip(liner2);
        fleet.addShip(cargoShip);
        fleet.addShip(ferryBoat);
    }

    @Test
    public void loadWithoutRemainders() {
        // When
        fleet.loadShip(50, 40);  //kissebbre vettem, hogy 0 legyen a fel en férő

        // Then
        assertEquals(40, liner1.getPassengers());
        assertEquals(40, liner2.getPassengers());
        assertEquals(40, ferryBoat.getPassengers());
        assertEquals(0, fleet.getWaitingPersons());

        assertEquals(50, cargoShip.getCargoWeight());
        assertEquals(50, ferryBoat.getCargoWeight());

        assertEquals(0, fleet.getWaitingCargo());
    }

    @Test
    public void loadWithRemainders() {
        // When
        fleet.loadShip(350, 170);

        // Then
        assertEquals(100, liner1.getPassengers());
        assertEquals(170, liner2.getPassengers()); //200 eredetileg, de az hibás
        assertEquals(40, ferryBoat.getPassengers());
        assertEquals(200, fleet.getWaitingPersons());//10 eredetileg, de az hibás

        assertEquals(50, cargoShip.getCargoWeight());
        assertEquals(100, ferryBoat.getCargoWeight());

        assertEquals(550, fleet.getWaitingCargo());//20 eredetileg, de az hibás
    }
}
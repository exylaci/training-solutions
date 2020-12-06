package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int cargoWeight, int passengers) {
        waitingCargo = 0;
        waitingPersons = 0;
        for (Ship one : ships) {
            if (one instanceof CanCarryPassengers) {
                waitingPersons += ((CanCarryPassengers) one).loadPassenger(passengers);
            }
            if (one instanceof CanCarryGoods) {
                waitingCargo += ((CanCarryGoods) one).loadCargo(cargoWeight);
            }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}

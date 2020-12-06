package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers {
    private CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassengers) {
        this.canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
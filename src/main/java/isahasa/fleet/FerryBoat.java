package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
    private CanCarryPassengers canCarryPassengers;
    private CanCarryGoods canCarryGoods;

    public FerryBoat(int maxCargoWeight, int maxPassengers) {
        this.canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
        this.canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
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

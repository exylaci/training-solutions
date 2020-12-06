package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {
    private int cargoWeight;
    private int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        this.cargoWeight = Math.min(cargoWeight, maxCargoWeight);
        return cargoWeight > maxCargoWeight ?
                cargoWeight - maxCargoWeight :
                0;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}

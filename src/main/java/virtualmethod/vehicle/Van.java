package virtualmethod.vehicle;

public class Van extends Car {
    private int cargoWeight;

    public Van(int numberPassenger, int vehicleWeight, int cargoWeight) {
        super(vehicleWeight, numberPassenger);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {
        return String.format("Van{cargoWeight=%d, numberOfPassenger=%d, vehicleWeight=%d}",
                cargoWeight, super.getNumberPassenger(), super.getVehicleWeight());
    }
}
package inheritanceconstructor.cars;

public class Jeep extends Car {
    private double extraCapacity;
    private double extraFuel;


    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
    }

    public void drive(int km) {
        double consumption = km * getFuelRate() / 100;
        if (getFuel() + extraFuel < consumption) {
            throw new RuntimeException("Not enough fuel available!");
        }
        if (consumption > extraCapacity - extraFuel) {
            consumption -= extraCapacity - extraFuel;
            extraFuel = 0;
            super.modifyFuelAmount(-consumption);
        } else {
            extraFuel -= consumption;
        }
    }

    public double calculateRefillAmount() {
        return extraCapacity - extraFuel + getTankCapacity() - getFuel();
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}

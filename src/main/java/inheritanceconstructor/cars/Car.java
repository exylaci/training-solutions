package inheritanceconstructor.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (tankCapacity < fuel) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel + this.fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank is overloaded!");
        }
        this.fuel += fuel;
        if (this.fuel < 0) {
            this.fuel = 0;
        }
    }

    public void drive(int km) {
        if (fuel < km * fuelRate / 100) {
            throw new RuntimeException("Not enough fuel available!");
        }
        fuel -= km * fuelRate / 100;
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }
}

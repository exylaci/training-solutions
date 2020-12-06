package virtualmethod.vehicle;

import java.util.List;

public class FerryBoat extends Vehicle {
    public final int MAX_CARRY_WEIGHT;

    private Car car;

    public FerryBoat(int MAX_CARRY_WEIGHT) {
        super(MAX_CARRY_WEIGHT);
        this.MAX_CARRY_WEIGHT = MAX_CARRY_WEIGHT;
    }

    public boolean canCarry(Car car){
        return car.getVehicleWeight()<MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car){
        if (  canCarry(car) ) {
            this.car=car;
            return true;
        }
        return false;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad()+car.getGrossLoad();
    }

    @Override
    public String toString() {
        return "FerryBoat{car=" + car.toString() + "}";
    }
}

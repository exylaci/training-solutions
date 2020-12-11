package week07.d5;

public class Truck extends Vehicle {
    private int numberOfGears;
    private TransmissionType transmissionType;

    public Truck() {
        this.numberOfGears = 5;
        this.transmissionType = TransmissionType.MANUAL;
    }

    public Truck(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}

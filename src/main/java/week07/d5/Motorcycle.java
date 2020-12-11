package week07.d5;

public class Motorcycle extends Vehicle {
    private int numberOfGears;
    private TransmissionType transmissionType;

    public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }

    public Motorcycle() {
        this.numberOfGears = 5;
        this.transmissionType = TransmissionType.SEQUENTIAL;
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

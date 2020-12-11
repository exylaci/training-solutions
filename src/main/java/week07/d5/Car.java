package week07.d5;

public class Car extends Vehicle {
    private int numberOfGears;
    private TransmissionType transmissionType;

    public Car() {
        this.numberOfGears = 5;
        this.transmissionType = TransmissionType.AUTOMATIC;
    }

    public Car(int numberOfGears, TransmissionType transmissionType) {
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

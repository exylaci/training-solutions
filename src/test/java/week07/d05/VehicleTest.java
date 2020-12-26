package week07.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    public void vehicleTest() {
        Vehicle vehicle1 = new Vehicle();
        assertEquals(5, vehicle1.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, vehicle1.getTransmissionType());

        Vehicle vehicle2 = new Vehicle(4, TransmissionType.AUTOMATIC);
        assertEquals(4, vehicle2.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, vehicle2.getTransmissionType());
    }

    @Test
    public void carTest() {
        Vehicle car1 = new Car();
        assertEquals(5, car1.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, car1.getTransmissionType());

        Vehicle car2 = new Car(3, TransmissionType.SEQUENTIAL);
        assertEquals(3, car2.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, car2.getTransmissionType());
    }

    @Test
    public void truckTest() {
        Vehicle truck1 = new Truck();
        assertEquals(5, truck1.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, truck1.getTransmissionType());

        Vehicle truck2 = new Truck(12, TransmissionType.AUTOMATIC);
        assertEquals(12, truck2.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, truck2.getTransmissionType());
    }

    @Test
    public void motorcycleTest() {
        Vehicle motrorcycle1 = new Motorcycle();
        assertEquals(5, motrorcycle1.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, motrorcycle1.getTransmissionType());

        Vehicle motorcycle2 = new Motorcycle(2, TransmissionType.MANUAL);
        assertEquals(2, motorcycle2.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, motorcycle2.getTransmissionType());
    }
}
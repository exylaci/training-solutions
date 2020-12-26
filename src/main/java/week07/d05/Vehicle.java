package week07.d05;

public class Vehicle {
    private int numberOfGears;
    private TransmissionType transmissionType;

    public Vehicle() {
        numberOfGears = 5;
        transmissionType = TransmissionType.MANUAL;
    }

    public Vehicle(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }


    public int getNumberOfGears() {
        return numberOfGears;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
//Készíts a week07d05 csomagba egy Vehicle, egy Car, egy Truck és egy Motorcycle osztályt.
// A Vehicle osztálynak legyen egy
// int getNumberOfGears és egy
// TransmissionType getTransmissionType metódusa.
//
// A fenti osztályok értelemszerűen öröklődjenek egymásból és
// mindegyiknek implementálja a sebességek számát és a váltó típusát.

// A lehetséges váltótípusok: MANUAL, AUTOMATIC, SEQUENTIAL.
// Az alapértelmezett váltó típus (a Vehicle osztályban) MANUAL, de
// a Car automatikus, míg
// a Motorcycle SEQUENTIAL.
//
// Az alapértelmezett sebesség szám 5.
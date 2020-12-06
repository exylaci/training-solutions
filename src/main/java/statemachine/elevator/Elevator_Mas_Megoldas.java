package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator_Mas_Megoldas {
    private Level currentFloor;
    private Door currentDoorState;
    private StringBuilder history = new StringBuilder();
    private List<Level> targets = new ArrayList<>();

    public enum Level {
        //További emeletek esetén csak hozzá kell adni a felsoroláshoz.
        GROUNDFLOOR(0, "Ground Floor"), FIRST_FLOOR(1, "First Floor");
        private final int floor;
        private final String name;

        Level(int floor, String name) {
            this.floor = floor;
            this.name = name;
        }
    }

    public enum Door {
        OPEN(" Open"), CLOSED(" Closed");
        private final String state;

        Door(String state) {
            this.state = state;
        }
    }

    public Elevator_Mas_Megoldas() {
        this(Level.GROUNDFLOOR, Door.OPEN);
    }

    public Elevator_Mas_Megoldas(Level floor, Door door) {
        this.currentFloor = floor;
        this.currentDoorState = door;
        history.append("[");
        addHistory();
    }

    private void addHistory() {
        history.append(currentFloor.name).append(currentDoorState.state).append(", ");
    }

    public String getHistory() {
        return history.substring(0, history.length() - 2) + "]";
    }

    public void work() {
        while (targets.size() > 0) {
            while (targets.get(0).floor != currentFloor.floor) {
                if (targets.get(0).floor < currentFloor.floor) {
                    changeDoorState(Door.CLOSED);
                    currentFloor = Level.values()[(currentFloor.floor + 1) % Level.values().length];
                } else {
                    changeDoorState(Door.CLOSED);
                    currentFloor = Level.values()[(currentFloor.floor - 1 + Level.values().length) % Level.values().length];
                }
                addHistory();
            }
            targets.remove(0);
            changeDoorState(Door.OPEN);
        }
    }

    private void changeDoorState(Door door) {
        if (currentDoorState != door) {
            currentDoorState = door;
            addHistory();
        }
    }

    public void pushButtonToGoToFirstFloor() {
        targets.add(Level.FIRST_FLOOR);
    }

    public void pushButtonToGoToGroundFloor() {
        targets.add(Level.GROUNDFLOOR);
    }

    public void pushCallButtonOnGroundFloor() {
        pushButtonToGoToGroundFloor();
    }

    public void pushCallButtonOnFirstFloor() {
        pushButtonToGoToFirstFloor();
    }
}
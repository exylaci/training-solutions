package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private ElevatorStates current;
    private StringBuilder history = new StringBuilder();
    private List<ElevatorStates> targets = new ArrayList<>();

    public Elevator() {
        this(ElevatorStates.GROUNDFLOOR_OPEN);
    }

    public Elevator(ElevatorStates elevatorStates) {
        current = elevatorStates;
        history.append("[");
        history.append(current);
    }

    public Elevator(Object startPosition) {
        this(((Elevator) startPosition).getCurrent());
    }

    public ElevatorStates getCurrent() {
        return current;
    }

    public void work() {
        while (targets != null && targets.size() > 0) {
            oneTask(targets.get(0));
            targets.remove(0);
        }
    }

    private void oneTask(ElevatorStates target) {
        while (current != target) {
            if (target.getValue() > current.getValue()) {
                current = current.onward();
            } else {
                current = current.backward();
            }
            history.append(", ");
            history.append(current);
        }
    }

    public void pushButtonToGoToFirstFloor() {
        targets.add(ElevatorStates.FIRST_FLOOR_OPEN);
    }

    public void pushButtonToGoToGroundFloor() {
        targets.add(ElevatorStates.GROUNDFLOOR_OPEN);
    }

    public void pushCallButtonOnGroundFloor() {
        pushButtonToGoToGroundFloor();
    }

    public void pushCallButtonOnFirstFloor() {
        pushButtonToGoToFirstFloor();
    }

    public String getHistory() {
        return history.toString() + "]";
    }
}
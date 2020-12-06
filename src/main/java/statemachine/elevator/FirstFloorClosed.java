package statemachine.elevator;

public class FirstFloorClosed extends Elevator {
    private static final ElevatorStates current = ElevatorStates.FIRST_FLOOR_CLOSE;

    public ElevatorStates getCurrent() {
        return current;
    }
}

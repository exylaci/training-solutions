package statemachine.elevator;

/**
 * @deprecated Ez az osztály csak a teszt kompatibilitás miatt van.
 * Inkább így hívd meg: = new Elevator(ElevatorStates.FIRST_FLOOR_CLOSED)
 */
public class FirstFloorClosed extends Elevator {
    private static final ElevatorStates current = ElevatorStates.FIRST_FLOOR_CLOSED;

    public ElevatorStates getCurrent() {
        return current;
    }
}
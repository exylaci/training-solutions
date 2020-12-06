package statemachine.elevator;

public enum ElevatorStates {

    GROUNDFLOOR_OPEN(0, "Ground Floor Open") {
        @Override
        public ElevatorStates onward() {
            return GROUNDFLOOR_CLOSED;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_OPEN;
        }
    },
    GROUNDFLOOR_CLOSED(1, "Ground Floor Closed") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_CLOSED;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_OPEN;
        }
    },
    FIRST_FLOOR_CLOSED(2, "First Floor Closed") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_OPEN;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_CLOSED;
        }
    },
    FIRST_FLOOR_OPEN(3, "First Floor Open") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_OPEN;
        }

        @Override
        public ElevatorStates backward() {
            return FIRST_FLOOR_CLOSED;
        }
    };
    private final int value;
    private final String name;

    ElevatorStates(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public abstract ElevatorStates onward();

    public abstract ElevatorStates backward();

    @Override
    public String toString() {
        return name;
    }
}
package statemachine.elevator;

public enum ElevatorStates {

    GROUNDFLOOR_OPEN(0, "Ground Floor Open") {
        @Override
        public ElevatorStates onward() {
            return GROUNDFLOOR_CLOSE;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_OPEN;
        }
    },
    GROUNDFLOOR_CLOSE(1, "Ground Floor Closed") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_CLOSE;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_OPEN;
        }
    },
    FIRST_FLOOR_CLOSE(2, "First Floor Closed") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_OPEN;
        }

        @Override
        public ElevatorStates backward() {
            return GROUNDFLOOR_CLOSE;
        }
    },
    FIRST_FLOOR_OPEN(3, "First Floor Open") {
        @Override
        public ElevatorStates onward() {
            return FIRST_FLOOR_OPEN;
        }

        @Override
        public ElevatorStates backward() {
            return FIRST_FLOOR_CLOSE;
        }
    };
    private final int value;
    private final String name;

    ElevatorStates(int value, String name) {
        this.value=value;
        this.name=name;
    }

//    ElevatorStates() {
//        this(0,"GROUND FLOOR OPEN");
//    }

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

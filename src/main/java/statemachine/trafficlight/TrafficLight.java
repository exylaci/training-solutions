package statemachine.trafficlight;

public enum TrafficLight {
    RED {
        @Override
        TrafficLight next() {
            return RED_YELLOW;
        }
    },

    RED_YELLOW {
        @Override
        TrafficLight next() {
            return GREEN;
        }
    },

    GREEN {
        @Override
        TrafficLight next() {
            return YELLOW;
        }
    },

    YELLOW {
        @Override
        TrafficLight next() {
            return RED;
        }
    };

    abstract TrafficLight next();
}

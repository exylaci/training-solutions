package ioreader.states;

public class State {
    public static final String SEPARATOR = "-";

    private String stateName;
    private String capital;

    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }

    public State(String stateNameAndCapital) {
        String[] split = stateNameAndCapital.split(SEPARATOR);
        if (split.length > 1) {
            stateName = split[0];
            capital = split[1];
        }
    }


    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }
}

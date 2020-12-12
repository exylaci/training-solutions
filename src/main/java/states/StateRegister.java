package states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {
    private List<State> states = new ArrayList<>();

    public void readStatesFromFile(String fileName) {
        states.clear();
        Path path = Path.of("src/main/resources").resolve(fileName);
        System.out.println(path.toString());
        try {
            String oneLine;
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            while ((oneLine = reader.readLine()) != null) {
                states.add(new State(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public String findCapitalByStateName(String stateName){
        for ( State one : states){
            if ( one.getStateName().equals(stateName)){
                return one.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }
}

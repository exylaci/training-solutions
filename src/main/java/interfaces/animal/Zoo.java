package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    public Zoo(List<Animal> animals) {
        this.animals = new ArrayList<>(animals);
    }
    public int getNumberOfAnimals(){
        return animals.size();
    }
    public int getNumberOfLegs(){
        int legs = 0;
        for (Animal one : animals){
            legs+=one.getNumberOfLegs();
        }
        return legs;
    }
}

package algorithmsmax.trainer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MaxAgeCalculatorTeszt {

    @Test
    public void testMaxAgeCalculator(){
        List<Trainer> trainers = new ArrayList<>();
        trainers.add( new Trainer("edző bá",56));
        trainers.add( new Trainer("gyúró",76));
        trainers.add( new Trainer("segéd ezdő",36));
        trainers.add( new Trainer("vizes nyolcas",16));

        assertEquals(76,new MaxAgeCalculator().trainerWithMaxAge(trainers).getAge());
        assertEquals("gyúró",new MaxAgeCalculator().trainerWithMaxAge(trainers).getName());
    }
}

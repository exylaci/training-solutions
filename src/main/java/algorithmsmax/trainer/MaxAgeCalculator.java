package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers){
        Trainer it = null;
        int max = Integer.MIN_VALUE;
        for ( Trainer one : trainers ) {
            if ( one.getAge() > max){
                max=one.getAge();
                it = one;
            }
        }
        return it;
    }
}

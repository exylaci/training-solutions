package algorithmsdecision.integers;

import java.util.List;

public class IntegerDecisionMaker {

    public boolean containsGreaterThan(List<Integer> numbers, int number){
        for ( int one : numbers ) {
            if ( one > number ){
                return true;
            }
        }
        return false;
    }

    public boolean containsLowerThan(List<Integer> numbers, int number){
        for ( int one : numbers ) {
            if ( one < number ){
                return true;
            }
        }
        return false;
    }
}

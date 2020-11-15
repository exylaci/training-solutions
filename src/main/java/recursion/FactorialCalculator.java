package recursion;

public class FactorialCalculator {

    public long getFactorial(int number){
        if ( number < 2 ){
            return 1;
        }
        return number * getFactorial(number-1);
    }

}

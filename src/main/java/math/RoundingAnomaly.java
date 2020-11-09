package math;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class RoundingAnomaly {
    private double[] randomNumbers(int size, double max, int scale){
        double[] randomNumbers = new double[size];
        for ( int i=0 ; i<size ; ++i){
            randomNumbers[i] = Math.round( new Random().nextDouble() * max * Math.pow(10,scale) )
                    / Math.pow(10,scale);
        }
        return randomNumbers;
    }

    private double roundAfterSum(double[] numbers){
        double total = 0;
        for (double number : numbers ) {
            total += number;
        }
        return Math.round(total);
    }

    private double sumAfterRound(double[] numbers){
        double total = 0;
        for (double number : numbers ) {
            total += Math.round( number );
        }
        return total;
    }

    public double difference(int size, double max, int scale){
        double[] randomNumbersArray = randomNumbers(size,max,scale);
        //  System.out.println(Arrays.deepToString(new double[][]{randomNumbersArray}));
        //  return Math.abs( roundAfterSum(randomNumbersArray) - sumAfterRound(randomNumbersArray) );
        return roundAfterSum(randomNumbersArray) - sumAfterRound(randomNumbersArray);
    }
    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();

        int differencies = 0;
        for ( int i=0 ; i<100 ; ++i ){
            differencies += (roundingAnomaly.difference(1000,1_000_000,5));
        }
        System.out.println( differencies/100.0 );

    }
}

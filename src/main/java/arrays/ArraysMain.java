package arrays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ArraysMain {

    public  String numberOfDaysAsString(){
        // 1. verzió:
        // int[] numberOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        // return Arrays.toString( numberOfDays );      // így túl triviális volt szórakoztam kicsit :)

        // 2. verzió:
        // ez meg a legrövidebb, de itt nem jön létre numberOfDays változó
        // return Arrays.toString( new int[] {31,28,31,30,31,30,31,31,30,31,30,31} );

        // 3. verzió (perverz)
        int[] numberOfDays = new int[12];
        for (int i=0 ; i<12 ; ++i){
            LocalDate d = LocalDate.of(2001,i+1,1);
            numberOfDays[i]=d.lengthOfMonth();
        }
        StringBuilder sb = new StringBuilder();
        for (int element : numberOfDays ) {
            sb.append(element);
            sb.append(", ");
        }
        return  sb.substring(0,sb.length()-2).toString();
    }

    public List<String> daysOfWeek(){
        return Arrays.asList( new String[] {
                "hétfő","kedd","szerda","csütörtök","péntel","szombat","vasárnap"});
    }

    public String multiplicationTableAsString(int size){
        int[][] table = new int[size][size];
        for(int i=0 ; i<size ; ++i)
            for (int j=0; j<size ; ++j)
                table[i][j]=(i+1)*(j+1);
        return Arrays.deepToString(table);
    }

    public static void main(String[] args) {
        ArraysMain a = new ArraysMain();
        System.out.println(a.numberOfDaysAsString());
        System.out.println("");

        System.out.println(a.daysOfWeek());
        System.out.println("");

        System.out.println(a.multiplicationTableAsString(4));
        System.out.println();
    }
}

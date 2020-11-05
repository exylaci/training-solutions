package arrayofarrays;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size){
        int[][] array = new int[size][size];
        for(int i=1 ; i<=size ; ++i)
            for(int j=1 ; j<=size ; ++j){
                array[i-1][j-1]=i*j;
            }
        return array;
    }

    public int[][] triangularMatrix(int size){
        int[][] array = new int[size][];
        for (int i=0 ; i<size ; ++i) {
            array[i] = new int[i+1];
            for (int j=0 ; j<i+1 ; ++j){
                array[i][j]=i;
            }
        }
        return array;
    }

    public int[][] getValues(){
        int[][] array = new int[12][];
        for(int i=1 ; i<13 ; ++i){
            LocalDate date = LocalDate.of(1999,i,1);
            int month = date.lengthOfMonth();
            array[i-1] = new int[month];
        }
        return array;
    }

    public void printArrayOfArrays(int[][] a){
        for (int[] oneArray : a ) {
            for (int oneElement : oneArray){
                int length;
                if (oneElement>0) {
                    length = (int) Math.log10(oneElement);
                } else {
                    length=0;
                }
                System.out.printf("   ".substring(0,2-length) + oneElement + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayOfArraysMain a = new ArrayOfArraysMain();
        System.out.println( Arrays.deepToString( a.multiplicationTable(4 ) ) );
        a.printArrayOfArrays(a.multiplicationTable(4));
        System.out.println();

        System.out.println( Arrays.deepToString( a.triangularMatrix(4) ) );
        a.printArrayOfArrays(a.triangularMatrix(4));
        System.out.println();

        System.out.println( Arrays.deepToString( a.getValues() ) );
        a.printArrayOfArrays(a.getValues());
    }
}

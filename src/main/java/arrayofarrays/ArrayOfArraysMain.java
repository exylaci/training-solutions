package arrayofarrays;

import java.lang.reflect.Array;
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

    public void printArrayOfArrays(int[][] a){
        for (int[] oneArray : a ) {
            for (int oneElement : oneArray){
                System.out.printf("   ".substring(0,2-(int)Math.log10(oneElement)) + oneElement + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayOfArraysMain a = new ArrayOfArraysMain();
        System.out.println(Arrays.deepToString(a.multiplicationTable(4)));
        a.printArrayOfArrays(a.multiplicationTable(10));
    }
}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class ArrayHandler {
    boolean contains(int[] source, int itemToFind){
        // return Arrays.stream(source).anyMatch(x -> x == itemToFind);

        for (int oneItem: source) {
            if (oneItem==itemToFind) return true;
        }
        return false;
    }

    int find(int[] source, int itemToFind){
        for(int i=0; i<source.length;++i){
            if(source[i]==itemToFind) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler a = new ArrayHandler();
        int[] i = {1,2,3,4};
        System.out.println( a.contains(i, 7) );
        System.out.println( a.find(i, 7) );

        System.out.println( a.contains(i, 3) );
        System.out.println( a.find(i, 3) );

        List<Integer> t = new ArrayList<>();

    }
}

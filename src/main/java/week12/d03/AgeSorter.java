package week12.d03;

import java.util.ArrayList;
import java.util.List;

public class AgeSorter {
    public int[] sortAges(int[] ages){
        if (ages==null) throw new IllegalArgumentException("The list is a must");

        List<Integer> sorted = new ArrayList<>();
        for (int i = 0;i<130;++i){
            for (int age : ages){
                if(age==i){
                    sorted.add(i);
                }
            }
        }
        int[] result = new int[sorted.size()];

        for(int i=0; i<sorted.size();++i){
            result[i]=sorted.get(i);
        }
        return result;
    }
}

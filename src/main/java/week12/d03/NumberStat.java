package week12.d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberStat {

    public int findUniqueMinimum(List<Integer> list){
        if(list==null||list.size()<2)throw new IllegalArgumentException("This list isn't enough long!");

//        Map<Integer,Integer> pieces = list.stream().
//                collect(Collectors.groupingBy(a,Collectors.counting()));

        List<Integer> temp = new ArrayList<>(list);
        Collections.sort(temp);

        if(temp.get(0)!= temp.get(1)) return temp.get(0);
        for(int i=1;i<temp.size()-1;++i){
            if(temp.get(i)!= temp.get(i+1) && temp.get(i-1)!= temp.get(i)){
                return  temp.get(i);
            }
        }
        if(temp.get(temp.size()-1)!= temp.get(temp.size()-2))return temp.get(temp.size()-1);

        throw new IllegalStateException("There is no unique element in this list.");
    }

    public static void main(String[] args) {
        NumberStat n = new NumberStat();
        System.out.println(n.findUniqueMinimum(List.of( 1,1,5,3,4,5,6,5,6,4,1,6,5,4)));
    }
}
//Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló
// listát. Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet!
// Ellenőrizd, hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
//pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
package week04;

import java.util.ArrayList;
import java.util.List;

public class CharOperations {
    public List<Integer> getPositionsOfChar(String base, String part){
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<base.length()-part.length()+1; ++i){
            if (base.substring(i,i+part.length()).equals(part)){
                result.add(i);
            }
        }
        return result;
    }
}

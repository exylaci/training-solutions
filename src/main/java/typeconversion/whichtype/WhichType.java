package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s){
        List<Type> result = new ArrayList<>();

        long l = Long.parseLong(s,2);
        System.out.print(l + " ");
        for ( Type type : Type.values() ) {
            if ( type.getMax()>=l && type.getMin()<=l ){
                result.add(type);
            }
        }
        return result;
    }
}

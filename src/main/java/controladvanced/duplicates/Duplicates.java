package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> original){
        List<Integer> result = new ArrayList<>();
        boolean notExists;
        for ( int i=0 ; i<original.size() ; ++i ){
            notExists = true;
//            for ( int j=0 ; j<result.size() ; ++j ){      //Ez a rész kellene h egy értéket csak egyszer adjon a listához.
//                if ( result.get(j) == original.get(i) ){
//                    notExists = false;
//                    break;
//                }
//            }
//            if (notExists){
                for ( int j=i+1 ; j<original.size() ; ++j ){
                    if ( original.get(j) == original.get(i) ){
                        notExists = false;
                        break;
                    }
                }
                if ( !notExists ){
                    result.add(original.get(i));
                }
//            }
        }
        return result;
    }
}

package week05.d3;

import java.util.List;

public class ListCounter {

    public String listMerger(List<String> texts){
        if ( texts==null ){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for ( String text : texts ){
            if ( text!=null && text.length()>0 && text.substring(0,1).toLowerCase().equals("a") ){
                result.append(text);
            }
        }
        if ( result.length()==0 ){
            result.append("0");
        }
        return result.toString();
    }
}
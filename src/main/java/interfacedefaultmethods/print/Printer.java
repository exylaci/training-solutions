package interfacedefaultmethods.print;

import java.util.List;

public class Printer {
    public String print(Printable printable){
        StringBuilder result = new StringBuilder();

        for ( int i= 0 ; i<printable.getLength();++i){
            if (! printable.getColor(i).equals(Printable.BLACK)){
                result.append("[");
                result.append(printable.getColor(i));
                result.append("]");
            }
            result.append(printable.getPage(i));
            result.append("\n");
        }
        return result.toString();
    }
}

package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {
    public List<String> filterLines(List<String> lines){
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {
//Innen kezdve hiányzik jópár sor
                continue;
            }
            if ( parts[0].length()!=7 ||
                    parts[0].indexOf("-")<0 ||
                    Integer.parseInt( parts[1] )<= 1970 ||
                    Integer.parseInt( parts[1] )>= 2019 ){
                continue;
//Eddig hiányzik jópár sor
            }
            validLines.add(line);
        }
        return validLines;
    }
}

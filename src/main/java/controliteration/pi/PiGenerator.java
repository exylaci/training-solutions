package controliteration.pi;

import week04.CharOperations;

public class PiGenerator {
    private final String VERS = "Nem a régi s durva közelítés, mi szótól szóig így kijön betűiket számlálva. " +
            "Ludolph eredménye már, ha itt végezzük húsz jegyen. De rendre kijő még tíz pontosan, Azt is bízvást ígérhetem.";

    public String getPi(){
        String pi = "";
        byte counter = 0;
        boolean first = true;

        for ( int i=0 ; i<VERS.length() ; ++i ){
            if (Character.isAlphabetic( VERS.charAt(i) )){
                ++counter;
            }else if ( counter>0 ){
                pi += counter;
                counter = 0;
                if (first) {
                    pi += '.';
                    first=false;
                }
            }
        }
        return pi;
    }
}

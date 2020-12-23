package controliteration.pi;

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
                //if (pi.length()==1) { pi+='.';}   //first helyett lehetne a pi sztring hosszát is vizsgálni,
                                                    //de igy lassabb a futás, mert mindig meg kell kérdezni pi hosszát
                if (first) {
                    pi += '.';
                    first=false;
                }
            }
        }
        return pi;
    }
}

package introexception.patient;

import java.util.Scanner;

public class SsnValidator {
    public boolean isValidSsn(String ssn){
        if ( ssn.length() != 9 ){
            return false;
        }
        int sum = 0;
        try {
            for (int i = 0; i < 8; ++i) {
                if (i % 2 == 0) {
                    sum += Integer.parseInt(ssn.substring(i, i + 1)) * 3;
                } else {
                    sum += Integer.parseInt(ssn.substring(i, i + 1)) * 7;
                }
            }
            if (sum % 10 == Integer.parseInt(ssn.substring(8))) {
                return true;
            }

        }catch (NumberFormatException e){}
        return false;
    }
}

//A TAJ számot a következő algoritmussal ellenőrizd:
//
// A TAJ szám egy kilenc számjegyből álló szám.
// A TAJ szám első nyolc számjegyéből
//  a páratlan helyen állókat hárommal,
//  a páros helyen állókat héttel szorozzuk,
//  és a szorzatokat összeadjuk.
//  Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz ellenőrző kódnak.
//  Ha az ellenőrző kód nem egyezik, akkor ne fogadd el a TAJ számot!
//
//Ne felejtsd el, hogy a számmá konvertálás kivételt dobhat!
package week10.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HikingFile {
    public Elevations getPlusElevation(InputStream source) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(source));
            Elevations result = new Elevations();
            String oneLine;
            double previousLevel = getAltitudeFromOneLine(reader.readLine());
            while ((oneLine = reader.readLine()) != null) {
                double currentLevel = getAltitudeFromOneLine(oneLine);
                result.changeAltitude(currentLevel, previousLevel);
                previousLevel = currentLevel;
            }
            return result;
        } catch (NullPointerException | IOException e) {
            throw new IllegalArgumentException("Can't read the coordinates!");
        }
    }

    private double getAltitudeFromOneLine(String oneLine) {
        String[] parts = oneLine.split(", ");
        if (parts.length > 2) {
            return safeParse(parts[2]);
        }
        throw new IllegalArgumentException("Invalid data file, missing the altitude data!");
    }

    private double safeParse(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid data file, contains text instead of number!");
        }
    }
}
//Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot
//  (mindegyik lebegőpontos érték).
//
// Ezt egy fájlba tárolja, melynek formátuma:
//47.497913, 19.040236, 400
//47.497912, 19.040232, 420
//47.497916, 19.040236, 410
//
//Írj a week10d01.HikingFile osztályba egy getPlusElevation() metódust, mely kap egy InputStream-et, és visszaadja
//külön az ereszkedések, és külön az emelkedések összegét. Azaz pl. 10,20,15,18 esetén az emelkedés 13, ugyanis (20 - 10) + (18 - 15).
//A 20 méterről 15 méterre ereszkedést pedig 5. (edited)
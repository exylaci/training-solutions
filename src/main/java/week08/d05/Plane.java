package week08.d05;

import java.io.*;

public class Plane {
    public int longestWaterPart(String fileName) {
        try (InputStream reader = Plane.class.getResourceAsStream(fileName)) {
            int maxLength = 0;
            int counter = 0;
            byte[] b = new byte[1];

            while (reader.available() > 0) {
                reader.read(b);
                if (b[0] == 48) {
                    maxLength = Math.max(maxLength, ++counter);
                } else {
                    counter = 0;
                }
            }
            return maxLength;

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }
}
//Egy repülőgéppel átszeljük az óceánt és a közben méréseket végzünk. Tudjuk, hogy partól indulunk és parthoz érünk.
//A méréseket adott időközönként egyenletesen végezzük. A mérések azt mutatják, hogy sziget vagy óceán fölött repülünk
//éppen. Az 1-es szigetet míg a 0 óceánt jelöl.
// pl.: 111000010100001 sorozatban egy három "hosszú" sziget majd négy hosszú "óceán", aztán sziget, víz, sziget,
// majd óceán és végül egy szigeten leszálltunk.
//
// A map.txt állományban egy "térképet" tárolunk.
//
// A feladat az, hogy "repüljünk" a térkép fölött végig és határozzuk meg a leghosszabb óceán szakasz hosszát.
// A térkép fölött csak egyszer repülhetünk el és amikor leszálltunk már tudnunk is kell az eredményt.
// (Magyarul ne olvasd be a file-t a memóriába) A feladatot a week08d05.Plane osztályba végezzük el.
//
// A térkép:
// 10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011
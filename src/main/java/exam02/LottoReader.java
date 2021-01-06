package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {
    public static final String SEPARATOR = ";";
    private int[] numbers = new int[90];

    public LottoReader(InputStream input) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                process(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void process(String oneLine) {
        String[] parts = oneLine.split(SEPARATOR);
        for (int i = 11; i < 16; ++i) {
            numbers[Integer.parseInt(parts[i]) - 1]++;
        }
    }

    public int getNumber(int number) {
        if (number > 0 && number < 91) {
            return numbers[number - 1];
        }
        throw new IllegalArgumentException("Wrong number!");
    }
}
//Az src/test/resources mappában találsz egy otos.csv fájlt (ez egyébként a
// https://bet.szerencsejatek.hu/jatekok/otoslotto/sorsolasok címről tölthető le), és olvasd be. Tárold el, hogy
// melyik számot hányszor húzták ki. A fájl pontosvesszővel (;) elválasztva tárolja a mezőket. A 12 - 16. mező
// (nullával indexelve 11 - 15) tárolja a kihúzott számokat.
//
//Írj egy LottoReader osztályt! Használj egy 90 elemű tömb attribútumot! Vigyázz, a 90-es szám a tömb 89. eleme.
//
//Konstruktorban töltsd be a fájlt, ami paraméterként egy InputStream-et vár. Mivel a fájl folytonosan frissül a
// megadott webhelyen és így a tesztesetek konkrét várt értékei is változhatnak, a mellékelt fájl alapján dolgozz!
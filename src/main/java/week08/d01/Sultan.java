package week08.d01;

import java.util.Arrays;

public class Sultan {
    public static final int NUMBER_OF_DAIS_AND_CELLS = 100;
    private Door[] doors = new Door[NUMBER_OF_DAIS_AND_CELLS];

    public Door[] onThe100thDais() {
        initialising();
        for (int i = 0; i < NUMBER_OF_DAIS_AND_CELLS; ++i) {
            for (int j = i; j < NUMBER_OF_DAIS_AND_CELLS; j += i + 1) {
                changeLock(j);
            }
        }
        return doors.clone();
    }

    private void changeLock(int j) {
        if (doors[j] == Door.CLOSE) {
            doors[j] = Door.OPEN;
        } else {
            doors[j] = Door.CLOSE;
        }
    }

    private void initialising() {
        for (int i = 0; i < NUMBER_OF_DAIS_AND_CELLS; ++i) {
            doors[i] = Door.CLOSE;
        }
    }

    public Door getDoorState(int number) {
        return doors[number];
    }

    public static void main(String[] args) {
        Sultan c = new Sultan();
        Door[] d = c.onThe100thDais();
        for (int i = 0; i < NUMBER_OF_DAIS_AND_CELLS; ++i) {
            if (d[i] == Door.OPEN)
                System.out.println(i + 1 + " " + d[i]);
        }
    }
}
//A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből.
// A börtönben 100 cella van. Mindegyik cella zárva van.
// Ha egyet fordítunk a kulcson akkor nyitva lesz, ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
// A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.
// (Ekkor minden cella nyitva lesz)
// A második napon minden másodikon fordítsanak egyet, így minden második zárva lesz.
// A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz.
// A week08d01.Sultan osztályba írj egy metódust openDoors() néven,
// aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a 100. napon! Az osztály szabadon bővíthető!
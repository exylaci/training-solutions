package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Travel {
    public int getStopWithMax(InputStream inputStream) {
        if (inputStream == null) throw new IllegalArgumentException("Input stream is a must!");

        List<Integer> passengers = load(inputStream);
        int[] stops = countPassengers(passengers);
        return maxPassenger(stops);
    }

    private int maxPassenger(int[] stops) {
        int max = -1;
        int stop = -1;
        for (int i = 0; i < stops.length; ++i) {
            if (stops[i] > max) {
                max = stops[i];
                stop = i;
            }
        }
        return stop;
    }

    private int[] countPassengers(List<Integer> passengers) {
        int[] stops = new int[30];
        for (Integer passenger : passengers) {
            ++stops[passenger];
        }
        return stops;
    }

    private List<Integer> load(InputStream inputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<Integer> passengers = new ArrayList<>();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                String[] parts = oneLine.split(" ");
                passengers.add(Integer.parseInt(parts[0]));
            }
            return passengers;

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from " + inputStream);
        }
    }

}
//Adott egy fájl, utasadat.txt, mely a következőket tartalmazza:0 20190326-0700 6572582 RVS 20210101
//0 20190326-0700 8808290 JGY 7
//0 20190326-0700 1680423 TAB 20190420
//12 20190326-0716 3134404 FEB 20190301
//12 20190326-0716 9529716 JGY 0Ebből a megálló száma az első oszlop.Feladat: írj egy
// Travel.getStopWithMax(InputStream) metódust, mely
//visszaadja, hogy melyik megállóban szerettek volna a legtöbben felszállni.
package week11.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Courier {
    public static final String CANT_READ_FROM_FILE = "Can't read from this file: ";

    private List<Ride> rides = new ArrayList<>();

    public List<Ride> getRideList() {
        return Collections.unmodifiableList(rides);
    }

    public void loadTransports(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
            rides.clear();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                rides.add(new Ride(oneLine));
            }
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException(CANT_READ_FROM_FILE + fileName);
        }
    }

    public Ride findFirstTransport() {
        Ride result = null;
        int firstDay = 8;
        for (Ride ride : rides) {
            if (ride.getDay() < firstDay && ride.getTransport() == 1) {
                firstDay = ride.getDay();
                result = ride;
            }
        }
        return result;
    }

    public List<Integer> dayOffs() {
        boolean[] days = new boolean[7];
        for (Ride ride : rides) {
            days[ride.getDay() - 1] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            if (!days[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public Map<Integer, Integer> getDailyDistances() {
        int[] distances = new int[7];
        for (Ride ride : rides) {
            distances[ride.getDay() - 1] += ride.getDistance();
        }

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < 7; ++i) {
            result.put(i + 1, distances[i]);
        }
        return result;
    }
}

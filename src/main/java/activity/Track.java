package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track {
    public static final String INVALID_DATA_FILE_ERROR = "Invalid data file!";
    public static final String CANT_READ_FROM_FILE_ERROR = "Can't read from file!";
    public static final String TAG_COORDINATE = "<trkpt";
    public static final String SEPARATOR_OF_COORDINATES = "\"";
    public static final String TAG_ELEVATION_START = "<ele>";
    public static final String TAG_ELEVATION_STOP = "</ele>";

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return Collections.unmodifiableList(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getFullElevation() {
        if (trackPoints == null || trackPoints.size() < 2) return 0;

        double result = 0;
        for (int i = 1; i < trackPoints.size(); ++i) {
            result += Math.max(trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation(), 0);
        }
        return result;
    }

    public double getFullDecrease() {
        if (trackPoints == null || trackPoints.size() < 2) return 0;

        double result = 0;
        for (int i = 1; i < trackPoints.size(); ++i) {
            result += Math.max(trackPoints.get(i - 1).getElevation() - trackPoints.get(i).getElevation(), 0);
        }
        return result;
    }

    public double getDistance() {
        if (trackPoints == null || trackPoints.size() < 2) return 0;

        double result = 0;
        for (int i = 1; i < trackPoints.size(); ++i) {
            result += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return result;
    }

    public Coordinate findMinimumCoordinate() {
        if (trackPoints == null || trackPoints.size() == 0) return null;

        double latitude = Double.MAX_VALUE;
        double longitude = Double.MAX_VALUE;
        for (TrackPoint one : trackPoints) {
            latitude = Math.min(latitude, one.getCoordinate().getLatitude());
            longitude = Math.min(longitude, one.getCoordinate().getLongitude());
        }
        return new Coordinate(latitude, longitude);
    }

    public Coordinate findMaximumCoordinate() {
        if (trackPoints == null || trackPoints.size() == 0) return null;

        double latitude = Double.MIN_VALUE;
        double longitude = Double.MIN_VALUE;
        for (TrackPoint one : trackPoints) {
            latitude = Math.max(latitude, one.getCoordinate().getLatitude());
            longitude = Math.max(longitude, one.getCoordinate().getLongitude());
        }
        return new Coordinate(latitude, longitude);
    }

    public double getRectangleArea() {
        if (trackPoints == null || trackPoints.size() < 2) return 0;

        Coordinate one = findMinimumCoordinate();
        Coordinate two = findMaximumCoordinate();
        return (two.getLatitude() - one.getLatitude()) * (two.getLongitude() - one.getLongitude());
    }

    public void loadFromGpx(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            trackPoints.clear();
            String oneline;
            Coordinate coordinate = null;
            while ((oneline = reader.readLine()) != null) {
                if (oneline.contains(TAG_COORDINATE)) {
                    coordinate = getCoordinate(oneline);
                }
                if (oneline.contains(TAG_ELEVATION_START)) {
                    trackPoints.add(new TrackPoint(coordinate, getElevation(oneline)));
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException(CANT_READ_FROM_FILE_ERROR, e);
        }
    }

    private double getElevation(String oneline) {
        return tryParse(oneline.replace(TAG_ELEVATION_START, "").replace(TAG_ELEVATION_STOP, "").trim());
    }

    private Coordinate getCoordinate(String oneline) {
        String[] parts = oneline.split(SEPARATOR_OF_COORDINATES);
        if (parts.length != 5) throw new IllegalStateException(INVALID_DATA_FILE_ERROR);
        return new Coordinate(tryParse(parts[1]), tryParse(parts[3]));
    }

    private double tryParse(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (NullPointerException e) {
            throw new IllegalStateException(INVALID_DATA_FILE_ERROR);
        }
    }
}
//Track osztály: TrackPoint-ok listáját tárolja. Le lehet kérdezni az összemelkedést, az össztávolságot. Valamint a
// pontokat, mint függvényt elképzelve a bennfoglaló téglalap területét.
//Írj egy loadFromGpx() metódust is, mely egy szabványos GPX fájlt tölt be! Itt azt figyeld, hogy a sor a <trkpt és
// <ele szöveggel kezdődik-e! Itt beégetheted, hogy a számok hanyadik karaktertől hanyadik karakterig tartanak.
// Egy Coordinate példányt hozz létre, ha belefutsz a <trkpt sorba! Egy TrackPoint példányt hozz létre, ha belefutsz
// a <ele sorba, és add hozzá a listához! Egy példa állományt az src/test/resources könyvtárban találsz.
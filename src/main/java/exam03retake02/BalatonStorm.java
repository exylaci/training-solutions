package exam03retake02;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BalatonStorm {
    public static final String DATA_START = "{";
    public static final String DATA_END = "}";
    List<Station> stations = new ArrayList<>();
    Station current = new Station();

    public List<String> getStationsInStorm(BufferedReader reader) {
        importData(reader);

        return stations
                .stream()
                .filter(Station::isStorm)
                .map(Station::getAllomas)
                .sorted(Comparator.comparing(Function.identity(), Collator.getInstance(new Locale("hu", "HU"))))
                .collect(Collectors.toList());
    }

    private void importData(BufferedReader reader) {
        try {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine.trim());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read the sttions data!", e);
        }
    }

    private void processOneLine(String oneLine) {
        if (oneLine.startsWith(DATA_START)) {
            current = new Station();
            return;
        }
        if (oneLine.startsWith(DATA_END)) {
            stations.add(current);
            return;
        }
        String key = getKey(oneLine);
        String value = getValue(oneLine);
        switch (key) {
            case "id":
                current.setId(Integer.parseInt(value));
                break;
            case "allomas":
                current.setAllomas(value);
                break;
            case "lat":
                current.setLat(Double.parseDouble(value));
                break;
            case "lng":
                current.setLng(Double.parseDouble(value));
                break;
            case "description":
                current.setDescription(value);
                break;
            case "level":
                current.setLevel(Integer.parseInt(value));
                break;
            case "groupId":
                current.setGroupId(value);
                break;
            case "stationType":
                current.setStationTipe(value);
                break;
        }
    }

    private String getValue(String oneLine) {
        String[] parts = oneLine.split(":");
        if (parts.length < 2 || parts[1].length() == 0) {
            return "";
        }
        return parts[1]
                .substring(0, parts[1].length() - 1)
                .replace('"', ' ')
                .trim();
    }

    private String getKey(String oneLine) {
        String[] parts = oneLine.split("\"");
        if (parts.length > 1) {
            return parts[1];
        }
        return "";
    }
}
//Balatoni viharjelzés
//
//A https://vmonitor.rsoe.hu/api/mapApi/stations.php címen le lehet tölteni az aktuális balatoni viharjelzéseket.
//
//Írj egy programot, mely kilistázza, hogy hol van vihar!
//Ábécésorrendbe rendezve!
//Azokon az állomásokon van vihar, ahol a level értéke 3.
//
//
//A BalatonStorm osztály getStationsInStorm() metódusát implementáld! Paraméterként kap egy BufferedReader-t, és visszaadja az állomások listáját.
//
//A fájl a következő formátumú.
//[
//  {
//    "id": 5,
//    "allomas": "Siófok (OMSZ)",
//    "lat": "46.910647",
//    "lng": "18.040237",
//    "description": "A közforgalmú MAHART kikötőtől délnyugatra kb. 200 méterre",
//    "level": 0,
//    "groupId": "BE",
//    "stationType": "LED"
//  },
//  {
//    "id": 6,
//    "allomas": "Siófok-H. Erzsébet",
//    "lat": "46.91567",
//    "lng": "18.06600000000003",
//    "description": "Hotel Erzsébet szálló tetején.",
//    "level": 0,
//    "groupId": "BE",
//    "stationType": "LED"
//  }
//]
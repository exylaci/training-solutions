package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Histogram {


    public String createHistogram(BufferedReader reader) {
        StringBuilder result = new StringBuilder();
        String oneLine;
        try {
            while ((oneLine = reader.readLine()) != null) {
                result.append(processOneLine(oneLine));
            }
            return result.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can't read!");
        }

    }

    private String processOneLine(String oneLine) {
        if (oneLine.isBlank()) {
            return "";
        }
        int pieces = Integer.parseInt(oneLine);
        return Stream
                .generate(() -> "*")
                .limit(pieces)
                .collect(Collectors.joining()) + "\n";
    }
}
//Hisztogram
//
//Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak. Majd hozz létre egy stringet, mely ugyanennyi
// sort tartalmaz, és annyi csillagot ír ki egymás mellé soronkont, amennyi a bemeneti fájlban lévő szám.
//
//Azaz a bemeneti fájl:
//3
//4
//1
//2
//
//A létrehozott String:
//***
//****
//*
//**
//
//Figyelj, hogy az algoritmusod lehetőleg hatékony legyen!
//A Histogram osztályba dolgozz, tesztje HistogramTest.
//Minden sor után legyen sortörés, az utolsó után is.
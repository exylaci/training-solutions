package iowritestring.school;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public static final String CAN_T_REACH_FILE = "Can't reach this file!";

    public void newMark(Path path, int mark) {
        try {
            Files.writeString(path, String.format("%s\n", mark), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalArgumentException(CAN_T_REACH_FILE);
        }
    }

    public void average(Path path) {
        try {
            List<String> marks = Files.readAllLines(path, StandardCharsets.UTF_8);
            int sum = 0;
            int counter = 0;
            for (String one : marks) {
                sum += Integer.parseInt(one);
                ++counter;
            }
            Files.writeString(path,
                    String.format("average: %.1f", (double) sum / counter).replace(',', '.'),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalArgumentException(CAN_T_REACH_FILE);
        }
    }
}
//Ebben a feladatban egy iskolai naplózó rendszert kell megvalósítanod.
//
//Készíts a school csomagban egy Diary nevű osztályt benne egy
//newMark() metódussal, ami paraméterül várja a tanuló
//nevét és egy
//jegyet!
//Ha létezik a "tanulo_neve.txt" akkor a jegyet hozzáfűzi az állomány végére.
//Ha nem, akkor egy új állományt hoz létre "tanulo_neve.txt" formátumban, és beleírja a jegyet.
//
//Azt, hogy létezik-e egy fájl a Files.exists(path) metódussal tudod eldönteni.
//A fájlok a src/main/resources/ könyvtárban legyenek!
//
//Az év végén a tanár szeretné a tanuló fájl utolsó sorába az átlagot beírni. Írj egy metódust
//average() névvel, ami a fájl utolsó sorába a jegyek átlagát írja be! Például "average: 5".
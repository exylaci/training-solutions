package erettsegik.majus2018.tarsalgo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logic {
    public static final String SEPARATOR = " ";
    public static final LocalTime END_OF_EXAMINED_PERIOD = LocalTime.of(15, 0);

    private final List<String[]> DATA;

    public Logic(String dataFile) {
        try (Stream<String> stream = Files.lines(Path.of(dataFile), StandardCharsets.UTF_8)) {

            DATA = stream
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(SEPARATOR))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from this file: " + dataFile, e);
        }
    }

    public Map<String, Integer> feladat2(int hour, int minute) {

        List<String[]> inThisMinute = getThisMinute(hour, minute);

        Map<String, Integer> result = getFirstEnter(inThisMinute);

        Integer lastOut = getLastOut(inThisMinute);
        if (lastOut != null) {
            result.put("last out", lastOut);
        }

        return result;
    }

    private List<String[]> getThisMinute(int hour, int minute) {
        return DATA.stream()
                .filter(parts -> Integer.parseInt(parts[0]) == hour)
                .filter(parts -> Integer.parseInt(parts[1]) == minute)
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getFirstEnter(List<String[]> inThisMinute) {
        Map<String, Integer> result = new HashMap<>();
        inThisMinute
                .stream()
                .filter(parts -> parts[3].equals("be"))
                .map(parts -> Integer.parseInt(parts[2]))
                .findFirst()
                .ifPresent(personId -> result.put("first in", personId));
        return result;
    }

    private Integer getLastOut(List<String[]> inThisMinute) {
        return inThisMinute
                .stream()
                .filter(parts -> parts[3].equals("ki"))
                .map(parts -> Integer.parseInt(parts[2]))
                .reduce(null, (out, personId) -> out = personId, Integer::sum);
    }

    public void feladat3(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path.resolve("athaladas.txt"))) {

            DATA.stream()
                    .map(part -> Integer.parseInt(part[2]))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .map(entrySet -> entrySet.getKey() + " " + entrySet.getValue())
                    .forEach(oneItem -> writeOneItem(writer, oneItem));

        } catch (IOException e) {
            throw new IllegalStateException("Can't create this file: " + path.resolve("athaladas.txt"), e);
        }
    }

    private void writeOneItem(BufferedWriter writer, String oneItem) {
        try {
            writer.write(oneItem);
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write into the athaladas.txt", e);
        }
    }

    public Set<Integer> feladat4() {
        Set<Integer> result = new HashSet<>();

        for (String[] oneRecord : DATA) {
            Integer personId = Integer.parseInt(oneRecord[2]);
            if (oneRecord[3].equals("be")) {
                result.add(personId);
            } else {
                result.remove(personId);
            }
        }

        return result;
    }

    public LocalTime feladat5() {
        LocalTime result = null;
        int max = 0;
        int counter = 0;

        for (String[] oneRecord : DATA) {
            if (oneRecord[3].equals("be")) {
                max = Math.max(max, ++counter);
            } else {
                --counter;
            }
            if (max == counter) {
                result = convertToLocalTime(oneRecord);
            }
        }

        return result;
    }

    private LocalTime convertToLocalTime(String[] oneRecord) {
        return LocalTime.of(Integer.parseInt(oneRecord[0]), Integer.parseInt(oneRecord[1]));
    }

    public List<String> feladat7(int personId) {
        List<String> result = new ArrayList<>();

        for (String[] oneRecord : selectThisPerson(personId)) {
            if (oneRecord[3].equals("be")) {
                result.add(formatToTwoDigits(oneRecord[0]) + ":" + formatToTwoDigits(oneRecord[1]) + "-");
            } else {
                result.set(result.size() - 1,
                        result.get(result.size() - 1) + formatToTwoDigits(oneRecord[0]) + ":" + formatToTwoDigits(oneRecord[1]));
            }
        }

        return result;
    }

    private List<String[]> selectThisPerson(int personId) {
        return DATA.stream()
                .filter(part -> Integer.parseInt(part[2]) == personId)
                .collect(Collectors.toList());
    }

    private String formatToTwoDigits(String value) {
        return value.length() == 1 ? "0" + value : value;
    }

    public Result8 feladat8(int personId) {
        int length = 0;
        boolean in = false;
        LocalTime enter = null;

        for (String[] oneRecord : selectThisPerson(personId)) {
            if (oneRecord[3].equals("be")) {
                enter = convertToLocalTime(oneRecord);
                in = true;
            } else {
                length += Duration.between(enter, convertToLocalTime(oneRecord)).toMinutes();
                in = false;
            }
        }

        if (in) {
            length += Duration.between(enter, END_OF_EXAMINED_PERIOD).toMinutes();
        }

        return new Result8(length, in);
    }
}
//Társalgó:
//
//Egy színház társalgójában még a délelőtti próbák alatt is nagy a forgalom. A színészek hosszabb-rövidebb
//beszélgetésekre térnek be ide, vagy éppen csak keresnek valakit. A feladatban a társalgó ajtajánál 9 és 15 óra között
//felvett adatokat kell feldolgoznia. Az ajto.txt fájlban időrendben rögzítették, hogy ki és mikor lépett be vagy ki a
//társalgó egyetlen ajtaján. A fájl soraiban négy, szóközzel elválasztott érték található. Az első két szám az áthaladás
//időpontja (óra, perc), a harmadik a személy azonosítója, az utolsó az áthaladás iránya (be/ki). A sorok száma
//legfeljebb 1000, a személyek azonosítója egy 1 és 100 közötti egész szám. Biztosan tudjuk, hogy a megfigyelés kezdetén
//(9 órakor) a társalgó üres volt, de a megfigyelés végén (15 órakor) még lehettek benn a társalgóban. A társalgóba be-
//és kilépéseket azok sorrendjében tartalmazza az állomány, még akkor is, ha a perc pontossággal rögzített adatok alapján
// egyezőség áll fenn. Például:
// Fájl adatai Bentlévők száma
// 9 1 2 be    1
// 9 1 9 be    2
// 9 3 15 be   3
// 9 5 9 ki    2
// 9 8 15 ki   1
// 9 8 20 be   2
// 9 8 26 be   3
// 9 13 4 be   4
// 9 13 26 ki  3
// ...         ...
//
//A fenti példában a szürke mintázatú részen a bemeneti fájl első néhány sora látható. A második sora azt mutatja, hogy a
//9-es azonosítójú személy 9 óra 1 perckor lépett be a társalgóba. A negyedik sorban olvasható, hogy 9 óra 5 perckor már
//ki is ment, tehát ekkor összesen 4 percet töltött bent. A szürke rész sorai mellett olvasható számok azt mutatják, hogy
//a be- vagy kilépést követően hányan vannak bent a társalgóban. Ez a szám egy percen belül akár többször is változhat.
//Készítsen programot, amely az ajto.txt állomány adatait felhasználva az alábbi kérdésekre válaszol! A program
//forráskódját mentse tarsalgo néven! (A program megírásakor a felhasználó által megadott adatok helyességét,
//érvényességét nem kell ellenőriznie, feltételezheti, hogy a rendelkezésre álló adatok a leírtaknak megfelelnek.) A
//képernyőre írást igénylő részfeladatok eredményének megjelenítése előtt írja a képernyőre a feladat sorszámát (például:
//4. feladat:)! Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár! Az ékezetmentes
//kiírás is elfogadott.
//
//1. Olvassa be és tárolja el az ajto.txt fájl tartalmát!
//
//2. Írja a képernyőre annak a személynek az azonosítóját, aki a vizsgált időszakon belül először lépett be az ajtón, és
//azét, aki utoljára távozott a megfigyelési időszakban!
//
//3. Határozza meg a fájlban szereplő személyek közül, ki hányszor haladt át a társalgó ajtaján! A meghatározott értékeket
//azonosító szerint növekvő sorrendben írja az athaladas.txtfájlba! Soronként egy személy azonosítója, és tőle egy
//szóközzel elválasztva az áthaladások száma szerepeljen!
//
//4. Írja a képernyőre azon személyek azonosítóját, akik a vizsgált időszak végén a társalgóban tartózkodtak!
//
//5. Hányan voltak legtöbben egyszerre a társalgóban? Írjon a képernyőre egy olyan időpontot (óra:perc), amikor a
//legtöbben voltak bent!
//
//6. Kérje be a felhasználótól egy személy azonosítóját! A további feladatok megoldásánál ezt használja fel!
//Feltételezheti, hogy a megadott azonosítóhoz tartozik adat a forrásfájlban.
//
//7. Írja a képernyőre, hogy a beolvasott azonosítóhoz tartozó személy mettől meddig tartózkodott a társalgóban! A kiírást
//az alábbi, 22-es személyhez tartozó példának megfelelően alakítsa ki!
// 11:22-11:27
// 13:45-13:47
// 13:53-13:58
// 14:17-14:20
// 14:57-
//
//8. Határozza meg, hogy a megfigyelt időszakban a beolvasott azonosítójú személy összesen hány percet töltött a
//társalgóban! Az előző feladatban példaként szereplő 22-es személy 5 alkalommal járt bent, a megfigyelés végén még bent
//volt. Róla azt tudjuk, hogy 18 percet töltött bent a megfigyelés végéig. A 39-es személy 6 alkalommal járt bent, a
//vizsgált időszak végén nem tartózkodott a helyiségben. Róla azt tudjuk, hogy 39 percet töltött ott. Írja ki, hogy a
//beolvasott azonosítójú személy mennyi időt volt a társalgóban, és a megfigyelési időszak végén bent volt-e még!
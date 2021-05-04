package erettsegik.oktober2018.kerites;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fence {
    public static final Path SOURCE_FILE = Path.of("src/main/resources/erettsegik/oktober2018/kerites").resolve("kerites.txt");
    public static final String FILE_READ_ERROR = "Can't read from file!";
    public static final String FILE_WRITE_ERROR = "Can't write the file!";

    private int houseNumber;

    public static void main(String[] args) {
        Fence fence = new Fence();

        fence.exercrise2(); //Csak streammel, nem beolvasva a fájlt a memóriába :)
        fence.exercrise3(); //Csak streammel, nem beolvasva a fájlt a memóriába :)
        fence.exercrise4(); //streammel, nem beolvasva a fájlt a Listába :)
        fence.exercrise5(); //streammel, nem beolvasva a fájlt a Listába :)
        fence.exercrise6("/Temp/kimenet.txt"); //streammel, nem beolvasva a fájlt a Listába :)
    }

    private void exercrise2() {
        System.out.printf("2. feladat:%n\t%d házat adtak el az utcában.%n", countRecords());
    }

    private void exercrise3() {
        long records = countRecords();
        String side;

        try (Stream<String> stream = Files.lines(SOURCE_FILE)) {
            side = stream
                    .filter(this::notBlank)
                    .skip(records - 1)
                    .map(this::whichSide)
                    .collect(Collectors.joining());
            System.out.printf("3. feladat:%n\tAz utcában az utolsó telket a %s oldalon adták el.%n", side);
        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }

        try (Stream<String> stream = Files.lines(SOURCE_FILE)) {
            System.out.printf("\tAz utolsó telek házszáma: %d%n",
                    stream
                            .filter(this::notBlank)
                            .filter(line -> isOnTheSameSide(line, side))
                            .count()
                            * 2 - (isEven(side) ? 0 : 1));
        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }
    }

    private void exercrise4() {

        try (Stream<String> stream = Files.lines(SOURCE_FILE)) {
            String colors = stream
                    .filter(this::notBlank)
                    .filter(this::isOdd)
                    .map(this::getColor)
                    .collect(Collectors.joining());

            for (int i = 0; i < colors.length() - 1; ++i) {
                if (colors.charAt(i) == colors.charAt(i + 1) && colors.charAt(i) != ':' && colors.charAt(i) != '#') {
                    System.out.printf("4. feladat%n\tA szomszédossal egyezik a kerítés színe: %d%n", i * 2 + 1);
                    return;
                }
            }
            System.out.printf("Nincsenek azonos kerítés színű szomszédok.%n");

        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }

    }

    private void exercrise5() {
        System.out.print("5. feladat\n\tAdjon meg a házszámot:");
        Scanner scanner = new Scanner(System.in);
        String gottenNumber = scanner.next();
        if (!gottenNumber.matches("[0-9]{1,4}")) {
            return;
        }
        int orderNumber = (Integer.parseInt(gottenNumber) - 3) / 2;

        String side = whichSide(String.valueOf(Integer.parseInt(gottenNumber) % 2));

        String colors;
        try (Stream<String> stream = Files.lines(SOURCE_FILE)) {
            colors = stream
                    .filter(line -> isOnTheSameSide(line, side))
                    .skip(Math.max(0, orderNumber))
                    .limit(orderNumber < 0 ? 2 : 3)
                    .map(this::getColor)
                    .collect(Collectors.joining());

        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }
        if (colors.length() < 2) {
            System.out.println("Nincs ilyen házszám!");
            return;
        }

        System.out.printf("\tA kerítés színe: %s%n", colors.charAt(orderNumber < 0 ? 0 : 1));

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!colors.contains(String.valueOf(c))) {
                System.out.println("Ajánlott lehetséges szín: " + c);
                return;
            }
        }
    }

    private void exercrise6(String outputpath) {
        System.out.println("6. feladat\n\tA páratlan oldal utcaképe kiírása ide: "+outputpath);

        try (Stream<String> stream1 = Files.lines(SOURCE_FILE);
             Stream<String> stream2 = Files.lines(SOURCE_FILE);
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputpath))) {

            stream1.filter(line -> line.startsWith("1"))
                    .forEach(line -> fenceColor(line, writer));

            writer.newLine();
            houseNumber = 1;

            stream2.filter(line -> line.startsWith("1"))
                    .forEach(line -> houseNumber(line, writer));

        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }
    }

    private String getColor(String line) {
        return line.substring(line.length() - 1);
    }


    private boolean isOdd(String line) {
        return line.startsWith("1");
    }

    private boolean notBlank(String line) {
        return !line.isBlank();
    }

    private long countRecords() {
        try (Stream<String> stream = Files.lines(SOURCE_FILE)) {
            return stream
                    .filter(this::notBlank)
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException(FILE_READ_ERROR);
        }
    }

    private boolean isOnTheSameSide(String line, String side) {
        return line.startsWith((isEven(side) ? "0" : "1"));
    }

    private boolean isEven(String side) {
        return side.equals("páros");
    }

    private String whichSide(String oneLine) {
        if (oneLine.startsWith("0")) {
            return "páros";
        }
        return "páratlan";
    }

    private void fenceColor(String line, BufferedWriter writer) {
        String[] parts = line.split(" ");

        try {
            writer.write(Stream
                    .iterate(parts[2], n -> parts[2])
                    .limit(Integer.parseInt(parts[1]))
                    .collect(Collectors.joining()));

        } catch (IOException e) {
            throw new IllegalStateException(FILE_WRITE_ERROR);
        }
    }

    private void houseNumber(String line, BufferedWriter writer) {
        String[] parts = line.split(" ");

        try {
            writer.write(String.format("%-" + parts[1] + "s", String.valueOf(houseNumber)));
        } catch (IOException e) {
            throw new IllegalStateException(FILE_WRITE_ERROR);
        }

        houseNumber += 2;
    }
}

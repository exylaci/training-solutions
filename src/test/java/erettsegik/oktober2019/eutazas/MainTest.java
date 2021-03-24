package erettsegik.oktober2019.eutazas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static List<Trip> trips;

    @BeforeAll
    static void init() {
        trips = new ArrayList<>();

        trips.add(new Trip("19 20190326-0725 7067778 FEB 20190325"));
        trips.add(new Trip("17 20190326-0725 8781504 JGY 1"));
        trips.add(new Trip("19 20190326-0725 8781503 JGY 0"));
        trips.add(new Trip("20 20190326-0725 8781502 JGY 7"));
        trips.add(new Trip("17 20190326-0725 6917575 TAB 20190326"));
        trips.add(new Trip("1 20190326-0725 6917576 NYB 20190327"));
        trips.add(new Trip("5 20190326-0725 6917577 NYP 20190328"));
        trips.add(new Trip("7 20190326-0725 6917578 RVS 20190329"));
        trips.add(new Trip("6 20190326-0725 6917579 GYK 20190330"));
    }

    @Test
    void feladat1() {
        Main m = new Main(new ArrayList<>());
        m.excercrise1("utasadat.txt");
        assertEquals(699, m.getTrips().size());
    }

    @Test
    void feladat2() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        new Main(trips).excercrise2();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("A buszra 9 utas akart felszállni."));
    }

    @Test
    void feladat3() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        new Main(trips).excercrise3();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("A buszra 2 utas nem szállhatott fel."));
    }

    @Test
    void feladat4() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        new Main(trips).excercrise4();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("A legtöbb utas (2 fő) a 17. megállóban próbált felszállni."));
    }

    @Test
    void feladat5() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        new Main(trips).excercrise5();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("Ingyenesen utazók száma: 3 fő"));
        assertTrue(baos.toString().contains("A kedvezményesen utazók száma: 2 fő"));
    }

    @TempDir
    Path tempDirectory;

    @Test
    void feladat7() throws IOException {
        new Main(trips).excercrise7(tempDirectory);

        assertTrue(Files.exists(tempDirectory.resolve("figyelmeztetes.txt")));
        assertTrue(Files.size(tempDirectory.resolve("figyelmeztetes.txt")) >= 5 * 19);
        assertTrue(Files.size(tempDirectory.resolve("figyelmeztetes.txt")) <= 5 * 20 + 1);
    }


}
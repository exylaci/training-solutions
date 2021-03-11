package erettsegik.oktober2020.sorozatok;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @TempDir
    Path tempDirectiry;

    @Test
    void feladat1() {
        Main main = new Main(null);
        main.feladat1();

        assertEquals(219, main.getEpisodes().size());
    }

    @Test
    void feladat2() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(null);
        main.feladat1();
        main.feladat2();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("listában 202 db"));
    }

    @Test
    void feladat3() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(null);
        main.feladat1();
        main.feladat3();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("epizódok 45,66%-át látta"));
    }

    @Test
    void feladat4() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(null);
        main.feladat1();
        main.feladat4();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("Sorozatnézéssel 2 napot 15 órát és 32 percet"));
    }

    @Test
    void feladat5() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(new Scanner("2017.10.18"));
        main.feladat1();
        main.feladat5();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("15x04\tMilitary Police"));
    }

    @Test
    void feladat7() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(new Scanner("cs"));
        main.feladat1();
        main.feladat7();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("Spectacular Power"));
    }

    @Test
    void feladat7None() {
        PrintStream printStreamOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStreamNew = new PrintStream(baos);
        System.setOut(printStreamNew);

        Main main = new Main(new Scanner("szo"));
        main.feladat1();
        main.feladat7();

        System.out.flush();
        System.setOut(printStreamOld);

        assertTrue(baos.toString().contains("A megadott napon nem kerül adásba sorozat."));
    }

    @Test
    void wrtieLines() throws IOException {
        Main main = new Main(null);
        main.feladat1();

        Path path = tempDirectiry.resolve("teszt.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
        main.wrtieLines(writer);
        writer.close();

        assertTrue(Files.exists(path));
        assertTrue(Files.size(path) > 300);
    }

    @Test
    void wrtieLinesIntoMemory() throws IOException {
        Main main = new Main(null);
        main.feladat1();

        StringWriter sw = new StringWriter(500);
        BufferedWriter writer = new BufferedWriter(sw);

        main.wrtieLines(writer);

        writer.close();

        assertTrue(sw.toString().contains("Games 420 7"));
        assertTrue(sw.toString().contains("\nShrinktime 945 35"));
    }
}
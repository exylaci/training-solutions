package erettsegik.majus2019.cegesautok;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void excercrise1() {
        Main main = new Main();
        main.excercrise1("autok.txt");
        main.excercrise1("autok.txt");

        assertEquals(294, main.getParks().size());
    }

    @Test
    void findLastOutExists() throws NoSuchElementException {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 1"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        Optional<CarPark> result = new Main(temp, null).findTheLastOutCar();

        assertEquals(30, result.get().getDay());
        assertEquals("CEG300", result.get().getPlateNumber());
    }

    @Test
    void findLastOutNotFind() {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 18:42 CEG306 502 30942 1"));

        assertEquals(Optional.empty(), new Main(temp, null).findTheLastOutCar());
    }

    @Test
    void excercrise2Exists() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 1"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));
        new Main(temp, null).excercrise2();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("30. nap rendszám: CEG300"));
    }

    @Test
    void excercrise2NotFind() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 18:42 CEG306 502 30942 1"));
        new Main(temp, null).excercrise2();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("Nem vittek ki autót a garázsból"));
    }

    @Test
    void getCarsOnADay() {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 1"));
        temp.add(CarPark.of("29 14:30 CEG309 505 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        List<CarPark> result = new Main(temp, null).getCarsOnADay(29);

        assertEquals(2, result.size());
        assertEquals(506, result.get(1).getEmployeeId());
    }

    @Test
    void getNotReturnedCarOneIn() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 1"));
        temp.add(CarPark.of("29 14:30 CEG309 505 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        new Main(temp, null).excercrise4();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("A hónap végén 0 autót nem hoztak vissza"));
    }

    @Test
    void getNotReturnedCarOneOut() {
        PrintStream psOld = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 0"));
        temp.add(CarPark.of("29 14:30 CEG309 505 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        new Main(temp, null).excercrise4();

        System.out.flush();
        System.setOut(psOld);

        assertTrue(baos.toString().contains("A hónap végén 1 autót nem hoztak vissza"));
    }

    @Test
    void getDistances() {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 0"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 0"));
        temp.add(CarPark.of("30 09:03 CEG305 588 25924 1"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        Map<String, Integer> result = new Main(temp, null).getDistances();

        assertEquals(2, result.size());
        assertEquals(136, result.get("CEG300"));
        assertEquals(129, result.get("CEG309"));
    }

    @Test
    void getLongestEmployee() {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 0"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 0"));
        temp.add(CarPark.of("30 09:03 CEG305 517 25924 1"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        Optional<Map.Entry<Integer, Integer>> result = new Main(temp, null).getLongestEmployee();

        assertEquals(588, result.get().getKey());
        assertEquals(136, result.get().getValue());
    }

    @Test
    void getLongestEmployeeNoOne() {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("30 09:03 CEG300 588 30924 0"));
        temp.add(CarPark.of("28 14:03 CEG300 541 31154 1"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 1"));
        temp.add(CarPark.of("29 17:58 CEG309 507 13986 0"));

        Optional<Map.Entry<Integer, Integer>> result = new Main(temp, null).getLongestEmployee();

        assertEquals(Optional.empty(), result);
    }

    @Test
    void saveJourneySheet() throws IOException {
        List<CarPark> temp = new ArrayList<>();
        temp.add(CarPark.of("30 09:03 CEG300 588 35924 0"));
        temp.add(CarPark.of("28 14:03 CEG306 541 31154 0"));
        temp.add(CarPark.of("29 14:30 CEG309 506 13857 0"));
        temp.add(CarPark.of("29 17:58 CEG309 506 13986 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 1"));
        temp.add(CarPark.of("30 09:03 CEG300 588 35999 0"));
        temp.add(CarPark.of("30 09:03 CEG305 588 25924 1"));
        temp.add(CarPark.of("30 16:37 CEG300 588 36060 1"));

        StringWriter sw = new StringWriter(500);            //a várhatóan kiírandó adat mennyiségénél nagyobb szám
        BufferedWriter writer = new BufferedWriter(sw);

        new Main(temp, null).writeData("CEG300", writer);

        writer.close();
        assertTrue(sw.toString().contains("588  30. 09:03  35924 - 30. 09:03  35999"));
        assertTrue(sw.toString().contains("588  30. 09:03  35999 - 30. 16:37  36060"));
    }
}
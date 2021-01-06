package erettsegi2019;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EutazasTest {

    Eutazas eutazas = new Eutazas();

//    @BeforeAll
//    void beforeAll(){
//        eutazas.feladat1();
//    }

    @BeforeEach
    void beforeEach() {
        eutazas.feladat1();
    }

    @Test
    void feladat1Test() {
        List<PassangerData> result = eutazas.feladat1();
        PassangerData sample = new PassangerData(29,
                LocalDateTime.of(2019, 3, 26, 7, 36),
                "8417751",
                Type.GYK,
                LocalDate.of(2021, 1, 1));

        assertEquals(699, result.size());
        assertEquals(sample, result.get(698));
        Exception exception = assertThrows(UnsupportedOperationException.class, () ->
                result.add(sample));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void feladat2() {
        assertEquals(699, eutazas.feladat2());
    }

    @Test
    void feladat3() {
        assertEquals(29, eutazas.feladat3());
    }

    @Test
    void feladat4() {
        MaxPassanger maxPassanger = eutazas.feladat4();

        assertEquals(8, maxPassanger.getStop());
        assertEquals(39, maxPassanger.getMax());
    }

    @Test
    void feladat5() {
        FreeAndReducedPrice result = eutazas.feladat5();

        assertEquals(193, result.getReduced());
        assertEquals(133, result.getFree());
    }

    @TempDir
    Path tempDirectory;

    @Test
    void feladat7() throws IOException {
        eutazas.feladat7(tempDirectory);

        assertTrue(Files.exists(tempDirectory.resolve("figyelmeztetes.txt")));
        assertTrue(Files.size(tempDirectory.resolve("figyelmeztetes.txt"))>=48*19);
        assertTrue(Files.size(tempDirectory.resolve("figyelmeztetes.txt"))<=48*20+1);
    }
}
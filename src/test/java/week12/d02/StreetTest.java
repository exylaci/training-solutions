package week12.d02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {
    @TempDir
    Path temporallyPath;

    @Test
    void addParcelTest() {
        Street s = new Street();
        s.addParcel("0 10 P");
        s.addParcel("1 8 K");
        s.addParcel("1 10 :");
        s.addParcel("1 9 S");
        s.addParcel("0 10 P");
        s.addParcel("1 3 #");

        Parcel result = s.getSide("0").get(1);
        assertEquals(4, result.getNumero());
        assertEquals(10, result.getLength());
        assertEquals("(4)PPPPPPPPPP", result.toString());

        result = s.getSide("1").get(3);
        assertEquals(7, result.getNumero());
        assertEquals(3, result.getLength());
        assertEquals("(7)###", result.toString());
    }

    @Test
    void loadDataFromFileTest() {
        Street s = new Street();

        s.loadDataFromFile();

        assertEquals(39, s.getSide("0").size());
        assertEquals(59, s.getSide("1").size());

        Parcel result = s.getSide("0").get(37);
        assertEquals(76, result.getNumero());
        assertEquals(8, result.getLength());
        assertEquals("(76)EEEEEEEE", result.toString());

        result = s.getSide("1").get(57);
        assertEquals(115, result.getNumero());
        assertEquals(20, result.getLength());
        assertEquals("(115)ZZZZZZZZZZZZZZZZZZZZ", result.toString());
    }

    @Test
    void getParcelsBySizeTest() {
        Street s = new Street();
        s.addParcel("0 10 P");
        s.addParcel("1 8 K");
        s.addParcel("1 10 :");
        s.addParcel("1 9 S");
        s.addParcel("0 10 P");
        s.addParcel("1 3 #");

        List<Parcel> result = s.getParcelsBySize();

        assertEquals(6, result.size());
        assertEquals(7, result.get(0).getNumero());
        assertEquals(2, result.get(3).getNumero());
        assertEquals(4, result.get(5).getNumero());
    }

    @Test
    void writeToFileOdds() throws IOException {
        Street s = new Street();
        s.addParcel("0 10 P");
        s.addParcel("1 8 K");
        s.addParcel("1 10 :");
        s.addParcel("1 9 S");
        s.addParcel("0 10 P");
        s.addParcel("1 3 #");

        s.writeToFileOdds(temporallyPath.resolve("OddSide.txt"));

        assertEquals("(1)KKKKKKKK(3)::::::::::(5)SSSSSSSSS(7)###",
                Files.readString(temporallyPath.resolve("OddSide.txt")));
    }
}
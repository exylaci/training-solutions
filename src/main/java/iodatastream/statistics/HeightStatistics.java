package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {
    public void saveHeights(List<Integer> heights, Path path) {
        try {
            DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
            writer.writeInt(heights.size());
            for (Integer one : heights) {
                writer.writeInt(one);
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to file!", e);
        }
    }
}
//Az iodatastream.statistics csomagba készíts egy HeightStatistics osztályt, bele pedig egy
// saveHeights() metódust. A metódus egy kosárcsapat tagjainak testmagasságát kapja meg
// List<Integer> típusú paraméterben. A paraméterben kapott
// Path objektumként reprezentált fájlba menti
// először a lista méretét, majd egyenként a lista elemeit.
package iozip.names;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path path, List<String> employees) {
        try (ZipOutputStream ziped = new ZipOutputStream(new FileOutputStream(path.toFile()))) {
            ziped.putNextEntry(new ZipEntry("names.dat"));
            for (String one : employees) {
                ziped.write(one.getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Can't write file!", e);
        } catch (ZipException e) {
            throw new IllegalStateException("Can't create new entry in ZIP file!", e);
        } catch (IOException e) {
            throw new IllegalStateException("Baj van!", e);
        }
    }
}
//Az iozip.names csomagba készíts egy EmployeeFileManager osztályt! Egyetlen metódusa van, a
// saveEmployees(), mely a paraméterként kapott
// Path által reprezentált zip fájlba létrehoz egy
// names.dat nevű bináris fájlt, és a szintén paraméterként kapott
// névlista tartalmát beleírja.
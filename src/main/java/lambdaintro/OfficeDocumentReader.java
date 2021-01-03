package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {
    public final static List<String> EXTENSIONS = List.of(".docx", ".pptx", ".xlsx");

    public List<File> listOfficeDocuments(File file) {
        List<File> result = new ArrayList<>();

        File[] enries = file.listFiles(a -> a.isFile());
        for (File one : enries) {
            String name = one.getName().toLowerCase();
            if (EXTENSIONS.contains(name.substring(name.length() - (name.length() > 4 ? 5 : 0)))) {
                result.add(one);
            }
        }
        result.sort(Comparator.comparing(File::getName));
        return result;
    }
}
//Írj egy OfficeDocumentReader osztályt, abba egy List<File> listOfficeDocuments(File path) metódust,
//mely visszaadja a paraméterként átadott könyvtárban található összes docx, pptx és xlsx kiterjesztésű fájlt,
//név szerint sorbarendezve.
//
//Implementációs javaslat
//  Kizárólag lambda kifejezéseket vagy method reference-eket használj.
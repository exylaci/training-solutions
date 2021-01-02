package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {
    public static final Charset ENCODING = StandardCharsets.UTF_8;

    private Properties properties = new Properties();

    public DatabaseConfiguration() {
        try {
            properties.load(new BufferedReader(new InputStreamReader(
                    getClass().getResourceAsStream("db.properties"), ENCODING)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public DatabaseConfiguration(File fileName) {
        try {
            properties.load(Files.newBufferedReader(fileName.toPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public Integer getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
//Írj egy properties.DatabaseConfiguration osztályt, mely properties állományból betölti az adatbázis beállításokat,
//majd le lehet ezeket kérdezni. Létre lehet hozni paraméter nélküli konstruktorral, ekkor a classpath-ról tölti be a
//properties állományt. Van egy File paramétert váró konstruktora is, melyet megadva a beállításokat a paraméterként
//megadott fájlból tölti be.
//
//Megvalósítási javaslatok
//  Figyelj a karakterkódolásra. IDEA-ban, hogy a properties fájlt UTF-8 kódolással hozza létre, át kell állítani,
//  File / Settings / Editor / File Encodings ablakon a "Default encoding for properties files" értékét kell UTF-8-ra
//  állítani. A karakterkódolás konstans értékként legyen megadva.
//
//A betöltés a konstruktorban történjen. Érdemes felvenni egy Properties típusú attribútumot.
//  A getHost(), getPort() és getSchema() metódusok ezt hívják.
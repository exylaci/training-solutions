package properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {
    public static final String KEY_NAME = "name";
    public static final String KEY_URL = "url";
    public static final String KEY_SEPARATOR = ".";

    private Properties properties = new Properties();

    public JavaTools() {
        try {
            properties.load(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("javatools.properties"), StandardCharsets.UTF_8)));

        } catch (IOException e) {
            throw new IllegalStateException("Can't load configuration data!", e);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> result = new HashSet<>();
        for (String one : properties.stringPropertyNames()) {
            String[] parts = one.split("\\" + KEY_SEPARATOR);
            if (parts.length > 0) {
                result.add(parts[0]);
            }
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String one : getToolKeys()) {
            result.add(getName(one));
        }
        return result;
    }

    public String getName(String tool) {
        return properties.getProperty(tool + KEY_SEPARATOR + KEY_NAME);
    }

    public String getUrl(String tool) {
        return properties.getProperty(tool + KEY_SEPARATOR + KEY_URL);
    }
}
//Egy properties állományban tárold el a különböző Java eszközök leírásait a következő formátumban:
//
//jdk.name = Java Development Kit
//jdk.url = http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html
//maven.name = Apache Maven
//maven.url = https://maven.apache.org/
//junit.name = JUnit
//junit.url = http://junit.org/junit4/
//
//Írj egy properties.JavaTools osztályt, mely betölti ezen eszközöket a properties állományból.
// Legyen egy Set<String> getToolKeys() metódusa, mely visszaadja az eszközök kulcsait (pl. jdk, maven).
// Legyen egy Set<String> getTools() metódusa, mely visszaadja az eszközök neveit.
// Legyen egy String getName(String) metódusa, mely kulcs alapján visszaadja annak nevét,
// és egy String getUrl(String) metódusa, mely kulcs alapján visszaadja annak címét.
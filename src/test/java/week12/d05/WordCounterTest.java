package week12.d05;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void wordCounterTest() {
        assertEquals(29, new WordCounter().WordCounter(
                Path.of("src/main/resources/week12/d05/telex.hu.html")));
    }

    @Test
    void wordCounterParameterTestNotExists() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new WordCounter().WordCounter(Path.of("telex.hu.html")));
        assertEquals("Can't read from file: telex.hu.html", exception.getMessage());
    }

    @Test
    void wordCounterParameterTestNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new WordCounter().WordCounter(null));
        assertEquals("File name is a must!", exception.getMessage());
    }

    @Test
    void wordCounterTestURL() throws MalformedURLException {
//        assertEquals(29,new WordCounter().WordCounter(new URL("https://telex.hu/"),"virus"));
//      kikommenteztem, mert ha váltzozik a weboldal nem fog stimmelni a tesztben elvárt 29 találat.
    }
}
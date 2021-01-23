package week12.d04;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SecretTest {

    @Test
    void decoderTest() throws IOException {
        PrintStream psold = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream psNew = new PrintStream(baos);
        System.setOut(psNew);

        new Secret().decoder();

        System.out.flush();
        System.setOut(psold);

        assertEquals(baos.size(), Files.size(Path.of("src/main/resources/week12/d04/secret.dat")));

        Scanner scanner = new Scanner(baos.toString());
        assertEquals("       _", scanner.nextLine());
        assertEquals("      | |" , scanner.nextLine());
        assertEquals("      | | __ ___   ____ _" , scanner.nextLine());
        assertEquals("  _   | |/ _` \\ \\ / / _` |" , scanner.nextLine());
        assertEquals(" | |__| | (_| |\\ V / (_| |" , scanner.nextLine());
        assertEquals("  \\____/ \\__,_| \\_/ \\__,_|", scanner.nextLine());
    }
}
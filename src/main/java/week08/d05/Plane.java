package week08.d05;

import java.io.*;

public class Plane {
    public int longestWaterPart(String fileName) {
        try (InputStream reader = Plane.class.getResourceAsStream(fileName)) {
            int maxLength = 0;
            int counter = 0;
            byte[] b = new byte[1];

            while (reader.available() > 0) {
                reader.read(b);
                if (b[0] == 48) {
                    maxLength = Math.max(maxLength, ++counter);
                } else {
                    counter = 0;
                }
            }
            return maxLength;

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }
}

package week05.d5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SongTest {
    @Test
    public void constructorTest() {

        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Song(null, 1, "artist"));
        assertEquals(Song.ERROR_NAME, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                new Song("", 1, "artist"));
        assertEquals(Song.ERROR_NAME, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                new Song("name", 1, null));
        assertEquals(Song.ERROR_ARTIST, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                new Song("name", 1, ""));
        assertEquals(Song.ERROR_ARTIST, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                new Song("name", 0, "artist"));
        assertEquals(Song.ERROR_LENGTH, e.getMessage());
    }

    @Test
    public void toStringTest() {
        assertEquals("artist: song (27)", new Song("song", 27, "artist").toString());
    }
}

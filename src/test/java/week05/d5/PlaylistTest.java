package week05.d5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    @Test
    public void constructorTest() {

        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Playlist(null));
        assertEquals(Playlist.ERROR_PLAYLIST, e.getMessage());
    }

    @Test
    public void findByLengthGreaterThanTest() {
        Playlist p1 = new Playlist(Arrays.asList(
                new Song("egyik", 60, "egyikart"),
                new Song("egyik", 61, "egyikart")));
        Playlist p2 = new Playlist(Arrays.asList(
                new Song("egyik", 61, "egyikart")));
        assertEquals(
                p2.toString(),
                p1.findByLengthGreaterThan(1).toString());
    }
}

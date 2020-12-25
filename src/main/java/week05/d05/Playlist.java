package week05.d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public static final String ERROR_PLAYLIST = "Playlist is a must!";

    private List<Song> playlist = new ArrayList<>();

    public Playlist(List<Song> playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException(ERROR_PLAYLIST);
        }
        this.playlist = new ArrayList<>(playlist);
    }

    public List<Song> getPlaylist() {
        return new ArrayList<>(playlist);
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> result = new ArrayList<>();
        mins *= 60;
        for (Song one : playlist) {
            if (one.getLengthInSeconds() > mins) {
                result.add(one);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return playlist.toString();
    }
}
//Készítsünk egy Song osztályt, melynek az alábbi mezői vannak:
//    String name
//    long lengthInSeconds
//    String artist
//
//  A Song konstruktorában ellenőrizd, hogy a name és az artist üres-e!
//  Dobj kivételt, ha igen!
//  Ellenőrizd továbbá a lengthInSeconds-ot is, hogy nagyobb legyen, mint 0!
//
//Készítsünk egy Playlist osztályt, melynek van
//  egy konstruktora, amiben Song-ok listáját fogadja el!
//
// Írjunk egy metódust findByLengthGreaterThan néven, mely egy int-et vár paraméterként mins néven.
// Azoknak a Song-oknak a listáját adjuk vissza, melyek hosszabbak percben (!), mint a Song lengthInSeconds mezője.
//
//Bónusz feladat:
// Implementáljuk megfelelően a toString metódust a Song és a Playlist osztályban,
// hogy a Playliset-et kiirva a konzolra olvasható eredményt kapjunk!
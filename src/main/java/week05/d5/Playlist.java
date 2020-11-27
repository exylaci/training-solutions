package week05.d5;

import filescanner.library.Library;

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

package week05.d05;

public class Song {
    public final static String ERROR_NAME = "Name is a must!";
    public final static String ERROR_LENGTH = "Length mut be higher than 0!";
    public final static String ERROR_ARTIST = "Artist is a must!";

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
        if (isEmpty(artist)) {
            throw new IllegalArgumentException(ERROR_ARTIST);
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    private boolean isEmpty(String name) {
        if (name == null || name.isBlank()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d)", artist, name, lengthInSeconds);
    }
}
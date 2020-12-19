package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Invalid length");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Empty performers list");
        }
        this.title = title;
        this.length = length;
        this.performers = List.copyOf(performers);
        this.composer = new ArrayList<>();
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("Empty composer list.");
        }
        this.composer.addAll(composer);
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>(composer);
        result.addAll(performers);
        return result;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

}

package exam02.photo;

public class Photo implements Qualified {
    private String name;
    private Quality quality;

    public Photo(String name, Quality quality) {
        if (name == null) throw new IllegalArgumentException("Name is a must!");

        this.name = name;
        this.quality = quality;
    }

    public Photo(String name) {
        this(name, Quality.NO_STAR);
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public Quality getQuality() {
        return quality;
    }
}
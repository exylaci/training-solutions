package exam03retake02;

public class Station {
    private int id;
    private String allomas;
    private double lat;
    private double lng;
    private String description;
    private int level;
    private String groupId;
    private String stationTipe;

    public boolean isStorm() {
        return level >= 3;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAllomas(String allomas) {
        this.allomas = allomas;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setStationTipe(String stationTipe) {
        this.stationTipe = stationTipe;
    }

    public int getId() {
        return id;
    }

    public String getAllomas() {
        return allomas;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getStationTipe() {
        return stationTipe;
    }
}

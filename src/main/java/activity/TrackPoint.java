package activity;

public class TrackPoint {
    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint otherTrackPoint) {
        return distance(coordinate.getLatitude(), otherTrackPoint.getCoordinate().getLatitude(),
                coordinate.getLongitude(), otherTrackPoint.getCoordinate().getLongitude(),
                elevation, otherTrackPoint.getElevation());
    }

    private double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double height = el1 - el2;

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
        //Forrás: http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
    }
}
//TrackPoint osztály: Van egy koordináta és egy emelkedés adattagja. Tartalmaz egy getDistanceFrom(TrackPoint point)
// metódust mely, egy másik ponttól vett távolságot adja vissza. A földrajzi koordinátákkal való számoláshoz segítségül:
// http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
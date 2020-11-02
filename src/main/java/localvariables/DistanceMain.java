package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance=new Distance(3.14, true);
        System.out.println("The distance is " +
                (distance.isExact()?"exactly ":"about ") +
                distance.getDistanceInKm() +
                " km.");

        int distanceInt = (int) distance.getDistanceInKm();
        System.out.println("The distance is more than " + distanceInt + " km.");
    }
}

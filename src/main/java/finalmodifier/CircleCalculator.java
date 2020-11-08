package finalmodifier;

public class CircleCalculator {
    public final double PI = 3.14152965;

    public double calculatePerimeter(double r){
        return 2 * r * PI;
    }

    public double calculateArea(double r){
        return r * r * PI;
    }
}

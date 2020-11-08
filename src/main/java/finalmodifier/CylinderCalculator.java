package finalmodifier;

public class CylinderCalculator {
    public double calculateVolume(double r,double h){
        CircleCalculator circle = new CircleCalculator();
        return circle.calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r,double h){
        CircleCalculator circle = new CircleCalculator();
        return circle.calculateArea(r) * 2 + circle.calculatePerimeter(r) * h;
    }
}

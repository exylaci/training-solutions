package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator circle = new CircleCalculator();
        System.out.println(circle.calculateArea(10));
        System.out.println(circle.calculatePerimeter(10));

        CylinderCalculator cylinder = new CylinderCalculator();
        System.out.println(cylinder.calculateVolume(10,10));
        System.out.println(cylinder.calculateSurfaceArea(10,10));

        System.out.println("PI = " + circle.PI);
    }
}

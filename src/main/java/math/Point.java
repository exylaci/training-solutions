package math;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point other){
        return Math.sqrt(Math.pow(other.getY()-x,2)+Math.pow(other.getY()-y,2));
    }
}

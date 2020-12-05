package abstractclass.gamecharacter;

public class Point {
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point point) {
        return Math.round(Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2)));

    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

}

//Definiálj egy síkpont tárolására képes immutable Point osztályt, x és y long típusú attribútumokkal.
// Definiálj egy distance metódust, amely megkap egy másik pontot, és visszatér a két pont távolságával (Pitagorasz-tétel).
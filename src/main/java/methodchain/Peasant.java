package methodchain;

public class Peasant {
    public static final int MIN_X = 1;
    public static final int MAX_X = 8;
    public static final int MIN_Y = 1;
    public static final int MAX_Y = 8;

    private int posX;
    private int posY;

    public Peasant(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Peasant forward() {
        if (posX < MAX_X) {
            ++posX;
        }
        return this;
    }

    public Peasant back() {
        if (posX > MIN_X) {
            --posX;
        }
        return this;
    }

    public Peasant left() {
        if (posY > MIN_Y) {
            --posY;
        }
        return this;
    }

    public Peasant right() {
        if (posY < MAX_Y) {
            ++posY;
        }
        return this;
    }

    public String toString() {
        return "X: " + posX + ", Y: " + posY;
    }
}

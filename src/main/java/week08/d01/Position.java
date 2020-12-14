package week08.d01;

public class Position {
    private int x;
    private int y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(Position position) {
        x = position.getX();
        y = position.getY();
    }

    public void increaseX() {
        ++x;
    }

    public void decreaseX() {
        --x;
    }

    public void increaseY() {
        ++y;
    }

    public void decreaseY() {
        --y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

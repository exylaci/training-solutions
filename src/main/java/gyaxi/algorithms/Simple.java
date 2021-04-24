package gyaxi.algorithms;

public class Simple {
    public boolean method(String text) {
        return text == null;
    }

    public int method(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("Nem jó szám!");
        }
        return 0;
    }
}
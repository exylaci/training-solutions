package week12.d02;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parcel {
    private int numero;
    private int length;
    private String fence;

    public Parcel(int numero, int length, String fence) {
        this.numero = numero;
        this.length = length;
        this.fence = fence;
    }

    public int getNumero() {
        return numero;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("(%d)%s",
                numero,
                Stream.iterate(fence, (i) -> i)
                        .limit(length)
                        .collect(Collectors.joining()));
    }
}
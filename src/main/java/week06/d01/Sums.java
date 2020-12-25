package week06.d01;

public class Sums {
    private double positiv;
    private double negativ;

    public Sums(double positiv, double negativ) {
        this.positiv = positiv;
        this.negativ = negativ;
    }

    public double getPositiv() {
        return positiv;
    }

    public double getNegativ() {
        return negativ;
    }

    @Override
    public String toString() {
        return String.format("%.2f;%.2f", positiv, negativ);
    }
}

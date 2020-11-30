package week06.d1;

public class Sums {
    private Double positiv;
    private Double negativ;

    public Sums(Double positiv, Double negativ) {
        this.positiv = positiv;
        this.negativ = negativ;
    }

    public Double getPositiv() {
        return positiv;
    }

    public Double getNegativ() {
        return negativ;
    }

    @Override
    public String toString() {
        return String.format("%.2f;%.2f", positiv, negativ);
    }
}

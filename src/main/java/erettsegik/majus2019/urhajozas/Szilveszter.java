package erettsegik.majus2019.urhajozas;

public class Szilveszter {
    private final String megnevezes;
    private final int nap;

    public Szilveszter(String megnevezes, int nap) {
        this.megnevezes = megnevezes;
        this.nap = nap;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public int getNap() {
        return nap;
    }
}
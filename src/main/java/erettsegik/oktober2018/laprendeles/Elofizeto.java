package erettsegik.oktober2018.laprendeles;

import java.util.Objects;

public class Elofizeto {
    private int id;
    private String nev;
    private String utca;
    private String hazszam;

    public Elofizeto(String nev, String utca, String hazszam) {
        this.nev = nev;
        this.utca = utca;
        this.hazszam = hazszam;
    }

    public static Elofizeto parse(String all) {
        Elofizeto elofizeto = new Elofizeto();
        String[] parts = all.split("\t");
        elofizeto.id = Integer.parseInt(parts[0]);
        elofizeto.nev = parts[1];
        elofizeto.utca = parts[2];
        elofizeto.hazszam = parts[3];
        return elofizeto;
    }

    private Elofizeto() {
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getUtca() {
        return utca;
    }

    public String getHazszam() {
        return hazszam;
    }

    @Override
    public String toString() {
        return "Elofizeto{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", utca='" + utca + '\'' +
                ", hazszam='" + hazszam + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elofizeto elofizeto = (Elofizeto) o;
        return nev.equals(elofizeto.nev) && utca.equals(elofizeto.utca) && hazszam.equals(elofizeto.hazszam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, utca, hazszam);
    }
}
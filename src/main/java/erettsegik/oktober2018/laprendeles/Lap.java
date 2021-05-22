package erettsegik.oktober2018.laprendeles;

public class Lap {
    private int id;
    private String tema;
    private String cim;
    private int havi;
    private int negyedeves;
    private int feleves;
    private int eves;
    private int gyakorisag;

    public static Lap parse(String all) {
        Lap lap = new Lap();
        String[] parts = all.split("\t");
        lap.id = Integer.parseInt(parts[0]);
        lap.tema = parts[1];
        lap.cim = parts[2];
        lap.havi = parts[3].length() == 0 ? 0 : Integer.parseInt(parts[3]);
        lap.negyedeves = parts[4].length() == 0 ? 0 : Integer.parseInt(parts[4]);
        lap.feleves = parts[5].length() == 0 ? 0 : Integer.parseInt(parts[5]);
        lap.eves = parts[6].length() == 0 ? 0 : Integer.parseInt(parts[6]);
        lap.gyakorisag = Integer.parseInt(parts[7]);
        return lap;
    }

    public Lap(String tema, String cim, int gyakorisag) {
        this.tema = tema;
        this.cim = cim;
        this.gyakorisag = gyakorisag;
    }

    private Lap() {
    }

    public int getId() {
        return id;
    }

    public String getTema() {
        return tema;
    }

    public String getCim() {
        return cim;
    }

    public int getHavi() {
        return havi;
    }

    public int getNegyedeves() {
        return negyedeves;
    }

    public int getFeleves() {
        return feleves;
    }

    public int getEves() {
        return eves;
    }

    public int getGyakorisag() {
        return gyakorisag;
    }

    @Override
    public String toString() {
        return "Lap{" + tema + " - " + gyakorisag + " - " + cim + "}\n";
    }
}
package erettsegik.majus2020.akademikusok;


public class Report3 {
    private String nev;
    private String identitas;
    private String tipus;
    private int ev;

    public Report3(String nev, String identitas, String tipus, int ev) {
        this.nev = nev;
        this.identitas = identitas;
        this.tipus = tipus;
        this.ev = ev;
    }

    public String getNev() {
        return nev;
    }

    public String getIdentitas() {
        return identitas;
    }

    public String getTipus() {
        return tipus;
    }

    public int getEv() {
        return ev;
    }
}

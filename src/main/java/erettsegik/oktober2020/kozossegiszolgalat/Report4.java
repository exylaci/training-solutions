package erettsegik.oktober2020.kozossegiszolgalat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Report4 {
    private String osztaly;
    private String nev;
    private LocalDate datum;
    private LocalTime idopont;
    private int oraszam;
    private String tevekenyseg;

    public Report4() {
    }

    public Report4(String osztaly, String nev) {
        this.osztaly = osztaly;
        this.nev = nev;
    }

    public Report4(String osztaly, String nev, LocalDate datum, LocalTime idopont, int oraszam, String tevekenyseg) {
        this.osztaly = osztaly;
        this.nev = nev;
        this.datum = datum;
        this.idopont = idopont;
        this.oraszam = oraszam;
        this.tevekenyseg = tevekenyseg;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public String getNev() {
        return nev;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getIdopont() {
        return idopont;
    }

    public int getOraszam() {
        return oraszam;
    }

    public String getTevekenyseg() {
        return tevekenyseg;
    }

    @Override
    public String toString() {
        return osztaly + ' ' + nev + ' ' + datum + " " + idopont + " " + oraszam + " " + tevekenyseg;
    }
}

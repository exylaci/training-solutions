package erettsegik.oktober2020.kozossegiszolgalat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Report6 {
    private LocalDate datum;
    private LocalTime idopont;
    private int oraszam;
    private String tevekenyseg;

    public Report6(LocalDate datum, LocalTime idopont, int oraszam, String tevekenyseg) {
        this.datum = datum;
        this.idopont = idopont;
        this.oraszam = oraszam;
        this.tevekenyseg = tevekenyseg;
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
        return datum + " " + idopont + " " + oraszam + " " + tevekenyseg;
    }
}

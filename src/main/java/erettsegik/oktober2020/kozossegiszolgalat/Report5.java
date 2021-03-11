package erettsegik.oktober2020.kozossegiszolgalat;

public class Report5 {
    private String nev;
    private int tavlomaradasok;

    public Report5(String nev, int tavlomaradasok) {
        this.nev = nev;
        this.tavlomaradasok = tavlomaradasok;
    }

    public String getNev() {
        return nev;
    }

    public int getTavlomaradasok() {
        return tavlomaradasok;
    }

    @Override
    public String toString() {
        return String.format("%-30s %d", nev, tavlomaradasok);
    }
}

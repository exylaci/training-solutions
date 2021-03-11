package erettsegik.oktober2020.kozossegiszolgalat;

import javax.sql.DataSource;
import java.util.*;

public class Logic {
    Dao dao;

    public Logic(DataSource source) {
        this.dao = new Dao(source);
    }

    public void init() {
        dao.init();
    }

    public List<String> iskolaik() {
        return dao.iskolaik();
    }

    public Optional<Integer> oraszamok() {
        return dao.oraszamok();
    }

    public List<Report4> teljesitettek() {
        List<Report4> reports = dao.teljesitettek();

        List<Report4> result = new ArrayList<>();
        Report4 previous = new Report4();
        for (Report4 report : reports) {
            if (!report.getOsztaly().equals(previous.getOsztaly())) {
                result.add(new Report4(report.getOsztaly(), ""));
                result.add(new Report4("", report.getNev()));
            } else if (!report.getNev().equals(previous.getNev())) {
                result.add(new Report4("", report.getNev()));
            }
            result.add(new Report4(
                    "",
                    "",
                    report.getDatum(),
                    report.getIdopont(),
                    report.getOraszam(),
                    report.getTevekenyseg()));
            previous = report;
        }
        return result;
    }

    public List<Report5> tobbszor() {
        return dao.tobbszor();
    }

    public List<Report6> senki() {
        return dao.senki();
    }

    public Map<String, Integer> stat() {
        return dao.stat();
    }
}

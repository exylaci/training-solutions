package erettsegik.majus2020.akademikusok;

import javax.sql.DataSource;
import java.util.List;

public class Logic {
    private Dao dao;

    public Logic(DataSource source) {
        dao = new Dao(source);
    }

    public void clean() {
        dao.clean();
    }

    public List<String> feladat1() {
        return dao.feladat1();
    }

    public List<Report3> feladat3() {
        return dao.feladat2();
    }

    public List<Report4> feladat4() {
        return dao.feladat4();
    }

    public double feladat5() {
        return dao.feladat5();
    }

    public double feladat6() {
        return dao.feladat6();
    }

    public List<Report4> feladat7() {
        return dao.feladat7();
    }

    public List<Report8> feladat8() {
        return dao.feladat8();
    }
}
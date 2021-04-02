package erettsegik.oktober2019.forditoiroda;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Logic {
    Dao dao;

    public Logic(DataSource source, String location) {
        dao = new Dao(source);
        dao.create(location);
    }

    public void exercrise1(String nyelv, String doku, String szemely, String fordito) {
        loadNyelv(nyelv);
        loadDocu(doku);
        loadSzemely(szemely);
        loadFordito(fordito);
    }

    public void loadNyelv(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {

            reader.readLine();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                System.out.print(".");
                dao.insertIntoNyelv(Nyelv.createFromString(oneLine));
            }

        } catch (NullPointerException |
                IOException e) {
            throw new IllegalStateException("Nem lehet olvasni ezt a fájlt: " + fileName);
        }
    }

    public void loadDocu(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {

            reader.readLine();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                System.out.print(".");
                dao.insertIntoDokument(Documentum.createFromString(oneLine));
            }

        } catch (NullPointerException |
                IOException e) {
            throw new IllegalStateException("Nem lehet olvasni ezt a fájlt: " + fileName);
        }
    }

    public void loadSzemely(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {

            reader.readLine();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                System.out.print(".");
                dao.insertIntoSzemely(Szemely.createFromString(oneLine));
            }

        } catch (NullPointerException |
                IOException e) {
            throw new IllegalStateException("Nem lehet olvasni ezt a fájlt: " + fileName);
        }
    }

    public void loadFordito(String fileName) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {

            reader.readLine();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                System.out.print(".");
                dao.insertIntoFordito(Fordito.createFromString(oneLine));
            }

        } catch (NullPointerException |
                IOException e) {
            throw new IllegalStateException("Nem lehet olvasni ezt a fájlt: " + fileName);
        }
    }

    public List<String> exercrise2() {
        return dao.excercrise2();
    }

    public ReportData exercrise3() {
        return dao.excercrise3();
    }

    public List<ReportData> exercrise4() {
        return dao.excercrise4();
    }

    public List<ReportData> exercrise5() {
        return dao.excercrise5();
    }

    public String exercrise6() {
        return dao.excercrise6();
    }

    public List<String> exercrise7() {
        return dao.excercrise7();
    }

    public List<ReportData> exercrise8() {
        return dao.excercrise8();
    }
}

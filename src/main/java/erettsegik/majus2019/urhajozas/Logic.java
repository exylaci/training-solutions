package erettsegik.majus2019.urhajozas;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Logic {
    private Dao dao;

    public Logic(DataSource source) {
        dao = new Dao(source);
        dao.create();
    }

    public void load(String fileName, String table) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName), StandardCharsets.UTF_8))) {

            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                storeOneLine(oneLine, table);
            }
        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file", e);
        }
    }

    private void storeOneLine(String oneLine, String table) {
        switch (table) {
            case "urhajos":
                Urhajos urhajos = Urhajos.parse(oneLine);
                if (urhajos != null) {
                    dao.insertUrhajos(urhajos);
                }
                break;
            case "repules":
                Repules repules = Repules.of(oneLine);
                if (repules != null) {
                    dao.insertRepules(repules);
                }
                break;
            case "kuldetes":
                Kuldetes kuldetes = Kuldetes.of(oneLine);
                if (kuldetes != null) {
                    dao.insertKuldetes(kuldetes);
                }
        }
    }

    public Urhajos legtobbido() {
        return dao.legtobbido();
    }

    public List<Szilveszter> szilveszter() {
        return dao.szilveszter();
    }

    public List<TobbUrrepules> eletkor() {
        return dao.eletkor();
    }

    public List<UrhajosSzam> urhajosszam() {
        return dao.urhajosszam();
    }

    public int orszagszam() {
        return dao.orszagszam();
    }

    public List<String> ferfino() {
        return dao.ferino();
    }

    public List<Crew> legenyseg() {
        return dao.legenyseg();
    }
}
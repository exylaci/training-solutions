package erettsegik.oktober2018.laprendeles;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dao {
    private JdbcTemplate jdbcTemplate;

    public Dao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected void initialisation() {
        createTableLap();
        createTableElofizeto();
        createTableElofizetes();
        clearTables();
    }

    private void createTableLap() {
        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS lap(
                    id INT PRIMARY KEY,
                    tema VARCHAR(100),
                    cim VARCHAR(100),
                    havi INT,
                    negyedeves INT,
                    feleves INT,
                    eves INT,
                    gyakorisag int);""");
    }

    private void createTableElofizeto() {
        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS elofizeto(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nev VARCHAR(100),
                    utca VARCHAR(100),
                    hazszam VARCHAR(10))""");
    }

    private void createTableElofizetes() {
        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS elofizetes(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    eloid INT,
                    lapid INT,
                    FOREIGN KEY(eloid) REFERENCES elofizeto(id),
                    FOREIGN KEY(lapid) REFERENCES lap(id))""");
    }

    private void clearTables() {
        jdbcTemplate.update("DELETE FROM elofizetes");
        jdbcTemplate.update("DELETE FROM elofizeto");
        jdbcTemplate.update("DELETE FROM lap");
    }

    public void addLap(Lap lap) {
        jdbcTemplate.update(
                "INSERT INTO lap VALUES(?,?,?,?,?,?,?,?)",
                lap.getId(), lap.getTema(), lap.getCim(),
                lap.getHavi(), lap.getNegyedeves(), lap.getFeleves(), lap.getEves(),
                lap.getGyakorisag());
    }

    public void addElofizeto(Elofizeto elofizeto) {
        jdbcTemplate.update(
                "INSERT INTO elofizeto VALUES(?,?,?,?)",
                elofizeto.getId(), elofizeto.getNev(), elofizeto.getUtca(), elofizeto.getHazszam());
    }

    public void addElofizetes(Elofizetes elofizetes) {
        jdbcTemplate.update(
                "INSERT INTO elofizetes(eloid,lapid) VALUES(?,?)",
                elofizetes.getEloid(), elofizetes.getLapid());
    }

    public Map<String, Integer> havi2() {
        Map<String, Integer> result = new TreeMap<>();

        jdbcTemplate.query(
                "SELECT cim,havi FROM lap WHERE havi<>0 ORDER BY cim",
                (ResultSet rs) -> {
                    do {
                        result.put(rs.getString("cim"), rs.getInt("havi"));
                    } while (rs.next());
                });
        return result;
    }

    public List<Elofizeto> tobb3() {
        return jdbcTemplate.query(
                """
                        SELECT nev, utca, hazszam FROM elofizeto 
                        WHERE id IN (SELECT eloid FROM elofizetes GROUP BY eloid HAVING COUNT(eloid)>3)
                        ORDER BY nev""",
                (resultSet, index) -> new Elofizeto(
                        resultSet.getString("nev"),
                        resultSet.getString("utca"),
                        resultSet.getString("hazszam")));
    }

    public int osszesen4(String street, String number) {
        return jdbcTemplate.queryForObject(
                """
                        SELECT SUM(eves) AS total FROM lap
                        WHERE id IN (SELECT distinct(lapid) FROM elofizetes
                        WHERE eloid IN (SELECT id FROM elofizeto WHERE utca=? AND hazszam=?))""",
                (resultSet, index) -> resultSet.getInt("total"),
                street, number);
    }

    public String kedvezmeny5() {
        return jdbcTemplate.queryForObject(
                "SELECT cim, 12*havi-eves AS discount FROM lap WHERE eves <> 0 ORDER BY discount DESC LIMIT 1",
                ((resultSet, index) -> resultSet.getString("cim")));
    }

    public List<String> egyutt6(String title) {
        return jdbcTemplate.query(
                """
                        SELECT distinct cim FROM lap,elofizetes
                        WHERE  lapid = lap.id AND cim <> ? AND eloid IN (
                        SELECT eloid FROM elofizetes, lap
                        WHERE lapid = (SELECT id FROM lap WHERE cim=?))                                                """,
                (resultSet, index) -> resultSet.getString("cim"),
                title, title);
    }

    public Map<Elofizeto, String> heti7() {
        Map<Elofizeto, String> result = new HashMap<>();

        jdbcTemplate.query(
                """
                        SELECT nev, utca, hazszam, cim FROM lap, elofizetes, elofizeto
                        WHERE gyakorisag = 52
                            AND eloid = elofizeto.id
                            AND lapid = lap.id
                            AND eloid NOT IN (SELECT eloid FROM lap, elofizetes WHERE gyakorisag <> 52 AND lap.id = lapid)""",
                (resultSet, index) -> result.put(new Elofizeto(
                                resultSet.getString("nev"), resultSet.getString("utca"), resultSet.getString("hazszam")),
                        resultSet.getString("cim")));

        return result;
    }

    public List<Lap> ritkan8() {
        return jdbcTemplate.query(
                "SELECT tema, gyakorisag, cim FROM lap WHERE gyakorisag <= 12 ORDER BY tema, gyakorisag, cim",
                (resultSet, index) -> new Lap(
                        resultSet.getString("tema"),
                        resultSet.getString("cim"),
                        resultSet.getInt("gyakorisag")));
    }
}
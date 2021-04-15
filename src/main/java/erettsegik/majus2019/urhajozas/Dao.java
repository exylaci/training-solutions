package erettsegik.majus2019.urhajozas;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private JdbcTemplate jdbcTemplate;

    public Dao(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
    }

    public void create() {
        jdbcTemplate.update("DROP TABLE if EXISTS repules");
        jdbcTemplate.update("DROP TABLE if EXISTS kuldetes");
        jdbcTemplate.update("DROP TABLE if EXISTS urhajos");
        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS urhajos(
                    id int PRIMARY KEY,
                    nev VARCHAR(50) UNIQUE,
                    orszag VARCHAR(3),
                    nem VARCHAR(1),
                    szulev INT,
                    urido VARCHAR(10))""");

        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS kuldetes(
                    id INT PRIMARY KEY,
                    megnevezes VARCHAR(50),
                    kezdet DATE,
                    veg DATE)""");

        jdbcTemplate.update("""
                CREATE TABLE if NOT EXISTS repules(
                    urhajosid INT,
                    kuldetesid INT,
                    FOREIGN KEY (urhajosid) REFERENCES urhajos(id),
                    FOREIGN KEY(kuldetesid) REFERENCES kuldetes(id));""");
    }

    public void insertUrhajos(Urhajos urhajos) {
        jdbcTemplate.update(
                "INSERT INTO urhajos(id,nev,orszag,nem,szulev,urido) VALUE(?,?,?,?,?,?)",
                urhajos.getId(),
                urhajos.getName(),
                urhajos.getCountry(),
                urhajos.getSex().getValue(),
                urhajos.getBorn(),
                urhajos.getSpentTime());
    }

    public void insertKuldetes(Kuldetes kuldetes) {
        jdbcTemplate.update(
                "INSERT INTO kuldetes(id,megnevezes,kezdet,veg) VALUE(?,?,?,?)",
                kuldetes.getId(),
                kuldetes.getTitle(),
                kuldetes.getBegin(),
                kuldetes.getEnd());
    }

    public void insertRepules(Repules repules) {
        jdbcTemplate.update(
                "INSERT INTO repules(urhajosid,kuldetesid) VALUE(?,?)",
                repules.getUrhajosId(),
                repules.getKuldetesId());
    }

    public Urhajos legtobbido() {
        return jdbcTemplate.queryForObject(
                "SELECT nev, urido FROM urhajos WHERE nem='N' order by urido DESC LIMIT 1",
                (rs, rowNum) -> new Urhajos(
                        0,
                        rs.getString("nev"),
                        null,
                        null,
                        0,
                        rs.getString("urido")));
    }

    public List<Szilveszter> szilveszter() {
        return jdbcTemplate.query(
                "SELECT megnevezes, veg,kezdet, DATEDIFF(veg,kezdet) AS nap FROM kuldetes WHERE YEAR(kezdet)<>YEAR(veg)",
                (rs, rowNum) -> new Szilveszter(
                        rs.getString("megnevezes"),
                        rs.getInt("nap")));
    }

    public List<TobbUrrepules> eletkor() {
        return jdbcTemplate.query("""
                        SELECT nev, MIN(YEAR(kezdet)-szulev) AS elso, MAX(YEAR(kezdet)-szulev) AS utolso FROM repules
                            JOIN urhajos ON urhajos.id=urhajosid
                            JOIN kuldetes ON kuldetes.id=kuldetesid
                            GROUP BY urhajosid
                            HAVING COUNT(urhajosid)>1;""",
                (resultSet, rowNumber) -> new TobbUrrepules(
                        resultSet.getString("nev"),
                        resultSet.getInt("elso"),
                        resultSet.getInt("utolso")));
    }

    public List<UrhajosSzam> urhajosszam() {
        return jdbcTemplate.query(
                "SELECT orszag, COUNT(orszag) AS db FROM urhajos GROUP BY orszag ORDER BY db DESC, orszag",
                (resultSet, rowNumber) -> new UrhajosSzam(
                        resultSet.getString("orszag"),
                        resultSet.getInt("db")));
    }

    public Integer orszagszam() {
        return jdbcTemplate.queryForObject(
                "SELECT Count(allekerdezes.orszag) AS db FROM (SELECT orszag FROM urhajos GROUP BY orszag) AS allekerdezes",
                (rs, rowNum) -> rs.getInt("db"));
    }

    public List<String> ferino() {
        return jdbcTemplate.query("""
                        SELECT megnevezes FROM kuldetes
                           WHERE id in (SELECT kuldetesid FROM urhajos, repules WHERE urhajos.id = urhajosid AND nem='F')
                           AND id in (SELECT kuldetesid FROM urhajos, repules WHERE urhajos.id = urhajosid AND nem='N')""",
                (resultSet, rowNumber) -> resultSet.getString("megnevezes"));
    }

    public List<Crew> legenyseg() {
        List<Crew> result = new ArrayList<>();
        jdbcTemplate.query("""
                        SELECT megnevezes, kezdet, nev, orszag, nem FROM kuldetes, repules, urhajos
                            WHERE kezdet BETWEEN '1991-01-01' AND '2000-12-31'
                            AND kuldetes.id=kuldetesid AND urhajosid=urhajos.id
                            ORDER BY kezdet""",
                (ResultSet rs) -> {
                    do {
                        result.add(new Crew(
                                rs.getString("megnevezes"),
                                rs.getDate("kezdet").toLocalDate(),
                                rs.getString("nev"),
                                rs.getString("orszag"),
                                Sex.of(rs.getString("nem"))));
                    } while (rs.next());
                });
        return result;
    }
}

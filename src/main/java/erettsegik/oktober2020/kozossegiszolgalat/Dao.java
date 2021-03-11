package erettsegik.oktober2020.kozossegiszolgalat;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Dao {
    public static final String SEPARATOR = "\t";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm:ss");
    public static final String FLYWAY_DIRECTORY = "filesystem:src/main/resources/erettsegik/oktober2020/kozossegiszolgalat";

    private DataSource source;

    public Dao(DataSource source) {
        this.source = source;
    }

    public void init() {
        Flyway flyway = Flyway.configure().locations(FLYWAY_DIRECTORY).dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }


    public void fillupDiak(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO diak (nev,osztaly) VALUE (?,?)")) {

            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertLineToDiak(statement, oneLine);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to DIAK datatable", e);
        }
    }

    private void insertLineToDiak(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 2) {
            statement.setString(1, parts[1]);
            statement.setString(2, parts[2]);
            statement.executeUpdate();
        }
    }


    public void fillupTevekenyseg(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tevekenyseg (id,nev,iskolai) VALUE(?,?,?)")) {

            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertLineToTevekenyseg(statement, oneLine);

            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to TEVEKENYSEG datatable", e);
        }
    }

    private void insertLineToTevekenyseg(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 2) {
            statement.setInt(1, Integer.parseInt(parts[0]));
            statement.setString(2, parts[1]);
            statement.setBoolean(3, !parts[2].equals("0"));
            statement.executeUpdate();
        }
    }


    public void fillupMunka(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO munka (id,datum,kezdes,hossz,maxletszam,tevekenysegid) VALUE (?,?,?,?,?,?);")) {

            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertLineToMunka(statement, oneLine);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to MUNKA datatable", e);
        }
    }

    private void insertLineToMunka(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 5) {
            statement.setInt(1, Integer.parseInt(parts[0]));
            statement.setDate(2, Date.valueOf(LocalDate.parse(parts[1], DATE_FORMATTER)));
            statement.setTime(3, Time.valueOf(LocalTime.parse(parts[2], TIME_FORMATTER)));
            statement.setInt(4, Integer.parseInt(parts[3]));
            statement.setInt(5, Integer.parseInt(parts[4]));
            statement.setInt(6, Integer.parseInt(parts[5]));
            statement.executeUpdate();
        }
    }

    public void fillupJelentkezes(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO jelentkezes (diakid,munkaid,ervenyes,elfogadva,teljesitve) VALUES (?,?,?,?,?);")) {

            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertLineToJelentkezes(statement, oneLine);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to JELENTKEZES datatable", e);
        }
    }

    private void insertLineToJelentkezes(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 2) {
            statement.setInt(1, Integer.parseInt(parts[0]));
            statement.setInt(2, Integer.parseInt(parts[1]));
            statement.setBoolean(3, !parts[2].equals("0"));
            statement.setBoolean(4, !parts[3].equals("0"));
            statement.setBoolean(5, !parts[4].equals("0"));
            statement.executeUpdate();
        }
    }

    public List<String> iskolaik() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT nev FROM tevekenyseg WHERE iskolai=TRUE ORDER BY nev")) {

            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(resultSet.getString("nev"));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }

    public Optional<Integer> oraszamok() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT sum(hossz* maxletszam) AS oraszamok FROM munka")) {

            if (resultSet.next()) {
                return Optional.of(resultSet.getInt("oraszamok"));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }

    public List<Report4> teljesitettek() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT diak.osztaly,diak.nev,munka.datum,munka.kezdes,munka.hossz,jelentkezes.teljesitve,tevekenyseg.nev as tevekenysegnev FROM diak\s
                             	JOIN jelentkezes ON jelentkezes.diakid=diak.id
                             	JOIN munka ON munka.id=jelentkezes.munkaid
                             	JOIN tevekenyseg ON tevekenyseg.id=munka.tevekenysegid
                             	WHERE LEFT(osztaly,2)='10'  AND teljesitve=TRUE ORDER BY osztaly, diak.nev, munka.datum, munka.kezdes
                             """)) {

            List<Report4> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report4(
                        resultSet.getString("osztaly"),
                        resultSet.getString("nev"),
                        resultSet.getDate("datum").toLocalDate(),
                        resultSet.getTime("kezdes").toLocalTime(),
                        resultSet.getInt("hossz"),
                        resultSet.getString("tevekenysegnev")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }

    public List<Report5> tobbszor() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT
                                nev,
                             	id ,
                             	(SELECT COUNT(diakid) FROM jelentkezes WHERE teljesitve=FALSE AND diakid=id) AS db
                             	FROM diak
                             	WHERE (SELECT COUNT(diakid) FROM jelentkezes WHERE teljesitve=FALSE AND diakid=id)>1
                             	GROUP BY id
                             	ORDER BY nev
                             """)) {

            List<Report5> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report5(
                        resultSet.getString("nev"),
                        resultSet.getInt("db")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }

    public List<Report6> senki() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT diakid, datum,kezdes,hossz,tevekenyseg.nev FROM jelentkezes
                             	RIGHT JOIN munka ON munka.id=jelentkezes.munkaid
                             	JOIN tevekenyseg ON tevekenyseg.id=munka.tevekenysegid
                             	WHERE datum>'2016-10-28' AND datum<'2016-11-07' AND diakid IS NULL\s
                             	ORDER BY datum,kezdes
                             """)) {

            List<Report6> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report6(
                        resultSet.getDate("datum").toLocalDate(),
                        resultSet.getTime("kezdes").toLocalTime(),
                        resultSet.getInt("hossz"),
                        resultSet.getString("nev")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }

    public Map<String, Integer> stat() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT osztaly, COUNT(DISTINCT id) AS db  FROM diak
                             	JOIN jelentkezes ON id=diakid
                             	WHERE teljesitve=true
                             	GROUP BY osztaly
                             """)) {

            Map<String, Integer> result = new TreeMap<>();
            while (resultSet.next()) {
                result.put(
                        resultSet.getString("osztaly"),
                        resultSet.getInt("db"));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Query is failed!", e);
        }
    }
}

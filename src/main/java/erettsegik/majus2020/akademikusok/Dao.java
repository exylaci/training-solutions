package erettsegik.majus2020.akademikusok;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public static final String SEPARATOR = "\t";

    DataSource source;

    public Dao(DataSource source) {
        this.source = source;
    }

    public void clean() {
        Flyway flyway = Flyway
                .configure()
                .locations("filesystem:src/main/resources/erettsegik/majus2020/akademikusok")
                .dataSource(source)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    public void fillUpTag(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tag (id,nev,nem,szuletett,elhunyt,identitas) VALUE (?,?,?,?,?,?)")) {
            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertRecordToTag(statement, oneLine);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAG datatable", e);
        }
    }

    private void insertRecordToTag(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 3) {
            statement.setInt(1, Integer.parseInt(parts[0]));
            statement.setString(2, parts[1]);
            statement.setString(3, parts[2]);
            statement.setInt(4, (parts[3].isBlank() ? 0 : Integer.parseInt(parts[3])));
            statement.setInt(5, (parts.length < 5 || parts[4].isBlank() ? 0 : Integer.parseInt(parts[4])));
            statement.setString(6, (parts.length > 5 ? parts[5] : ""));
            statement.executeUpdate();
        }
    }

    public void fillUpTagsag(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tagsag (id,tagid,tipus,ev) VALUE (?,?,?,?)")) {
            String oneLine;
            reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                insertRecordToTagsag(statement, oneLine);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAGSAG datatable", e);
        }
    }

    private void insertRecordToTagsag(PreparedStatement statement, String oneLine) throws SQLException {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length > 3) {
            statement.setInt(1, Integer.parseInt(parts[0]));
            statement.setInt(2, Integer.parseInt(parts[1]));
            statement.setString(3, parts[2]);
            statement.setInt(4, Integer.parseInt(parts[3]));
            statement.executeUpdate();
        }
    }

    public List<String> feladat2() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT nev FROM tag WHERE elhunyt='' OR elhunyt IS NULL ORDER BY nev")) {

            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(resultSet.getString("nev"));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAGOK datatable", e);
        }
    }

    public List<Report3> feladat3() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT nev, identitas, tipus, ev FROM tag
                             JOIN tagsag ON tagid=tag.id
                             WHERE identitas<>'' AND identitas IS NOT NULL
                             ORDER BY ev,nev
                             """)) {

            List<Report3> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report3(
                        resultSet.getString("nev"),
                        resultSet.getString("identitas"),
                        resultSet.getString("tipus"),
                        resultSet.getInt("ev")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with AKADEMIKUSOK database!", e);
        }
    }

    public List<Report4> feladat4() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT nev, ev FROM tag
                             JOIN tagsag ON tagid=tag.id
                             GROUP BY tagid
                             ORDER BY ev
                             """)) {

            List<Report4> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report4(
                        resultSet.getString("nev"),
                        resultSet.getInt("ev")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with AKADEMIKUSOK database!", e);
        }
    }

    public double feladat5() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT (COUNT(id) / (SELECT COUNT(id) FROM tag) * 100) AS arany FROM tag WHERE nem='n'")) {

            if (resultSet.first()) {
                return resultSet.getDouble("arany");
            }
            return 0;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAG data table!", e);
        }
    }

    public double feladat6() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT avg(r.ev-l.ev) as atlag FROM tagsag AS r, tagsag AS l WHERE r.tagid=l.tagid AND r.tipus='r' AND l.tipus='l'")) {

            if (resultSet.first()) {
                return resultSet.getDouble("atlag");
            }
            return 0;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAGSAG data table!", e);
        }
    }

    public List<Report4> feladat7() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT nev, ev, elhunyt
                             	FROM tag, tagsag
                             	WHERE tag.id=tagid
                             		AND ev<=(SELECT ev FROM tagsag, tag WHERE tagsag.tagid=tag.id AND tag.nev='Teller Ede' AND tagsag.tipus='t')
                             		AND (elhunyt>=(SELECT elhunyt FROM tag WHERE tag.nev='Teller Ede')
                             		 OR elhunyt=0 )
                             		AND tipus='t'
                             """)) {

            List<Report4> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report4(
                        resultSet.getString("nev"),
                        resultSet.getInt("ev")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with TAGOK datatable", e);
        }
    }

    public List<Report8> feladat8() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     """
                             SELECT ev,	nev, concat(
                             		                szuletett,
                             		                '-',
                             		                case when elhunyt>0 then elhunyt END ) AS elt
                             	FROM tag, tagsag
                             	WHERE tag.id = tagid AND tipus='r' AND ev BETWEEN 1901 AND 2000
                             	ORDER BY ev, nev
                             """)) {

            List<Report8> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Report8(
                        resultSet.getInt("ev"),
                        resultSet.getString("nev"),
                        resultSet.getString("elt")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot work with AKADEMIKUSOK database", e);
        }
    }
}
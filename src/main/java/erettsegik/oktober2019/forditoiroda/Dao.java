package erettsegik.oktober2019.forditoiroda;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    DataSource source;

    public Dao(DataSource source) {
        this.source = source;
    }

    public void create(String location) {
        Flyway flyway = Flyway
                .configure()
                .locations(location)
                .dataSource(source)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    public void insertIntoDokument(Documentum documentum) {
        if (documentum == null) {
            return;
        }

        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO doku(id,terjedelem,szakterulet,nyelvid,munkaido) VALUES(?,?,?,?,?)")) {

            statement.setInt(1, documentum.getId());
            statement.setInt(2, documentum.getTerjedelem());
            statement.setString(3, documentum.getSzakterulet());
            statement.setInt(4, documentum.getNyelvId());
            statement.setInt(5, documentum.getMunkaido());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public void insertIntoNyelv(Nyelv nyelv) {
        if (nyelv == null) {
            return;
        }

        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO nyelv(id,fnyelv,cnyelv,egysegar) VALUES(?,?,?,?)")) {

            statement.setInt(1, nyelv.getId());
            statement.setString(2, nyelv.getFnyelv());
            statement.setString(3, nyelv.getCnyelv());
            statement.setInt(4, nyelv.getEgysegar());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public void insertIntoSzemely(Szemely szemely) {
        if (szemely == null) {
            return;
        }

        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO szemely(id,nev,elerheto) VALUES(?,?,?)")) {

            statement.setInt(1, szemely.getId());
            statement.setString(2, szemely.getName());
            statement.setBoolean(3, szemely.isElerheto());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public void insertIntoFordito(Fordito fordito) {
        if (fordito == null) {
            return;
        }

        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO fordito(nyelvid,szemelyid) VALUES(?,?)")) {

            statement.setInt(1, fordito.getNyelvid());
            statement.setInt(2, fordito.getSzemelyid());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public List<String> excercrise2() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT nev FROM szemely WHERE elerheto ORDER BY nev")) {

            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(resultSet.getString("nev"));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public ReportData excercrise3() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT COUNT(egysegar) AS pieces, SUM(egysegar) AS total
                         FROM doku JOIN nyelv ON nyelv.id=doku.nyelvid
                         WHERE doku.terjedelem<=5000""")) {

            if (resultSet.first()) {
                return new ReportData(
                        resultSet.getInt("pieces"),
                        resultSet.getInt("total"));
            }
            throw new IllegalStateException("No data available in the database!");

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public List<ReportData> excercrise4() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT
                        terjedelem,
                        szakterulet
                        FROM doku
                        JOIN nyelv ON nyelv.id=nyelvid
                        WHERE fnyelv='angol' AND cnyelv='magyar'
                        ORDER BY terjedelem DESC""")) {

            List<ReportData> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new ReportData(
                        resultSet.getInt("terjedelem"),
                        resultSet.getString("szakterulet")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public List<ReportData> excercrise5() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT szakterulet,fnyelv,cnyelv
                           FROM doku JOIN nyelv ON nyelvid=nyelv.id
                           WHERE munkaido BETWEEN 7 AND 9 ORDER BY fnyelv""")) {

            List<ReportData> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new ReportData(
                        resultSet.getString("szakterulet"),
                        resultSet.getString("fnyelv"),
                        resultSet.getString("cnyelv")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public String excercrise6() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT nev
                        FROM fordito
                           JOIN nyelv ON nyelvid=nyelv.id
                           JOIN szemely ON szemelyid=szemely.id
                        WHERE fnyelv='magyar'
                        GROUP BY nev
                        ORDER BY COUNT(cnyelv) DESC
                        LIMIT 1""")) {

            if (resultSet.first()) {
                return resultSet.getString("nev");
            }
            throw new IllegalStateException("No data available in the database!");

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public List<String> excercrise7() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT nev
                        FROM fordito
                        JOIN nyelv ON nyelvid=nyelv.id
                        JOIN szemely ON szemelyid=szemely.id
                        WHERE elerheto
                        AND fnyelv='magyar' AND (cnyelv='angol' OR cnyelv='orosz')
                        GROUP BY nev""")) {

            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(resultSet.getString("nev"));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }

    public List<ReportData> excercrise8() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT distinct szakterulet, fnyelv, cnyelv
                          FROM doku JOIN nyelv ON nyelvid=nyelv.id
                          ORDER BY szakterulet, fnyelv""")) {

            List<ReportData> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new ReportData(
                        resultSet.getString("szakterulet"),
                        resultSet.getString("fnyelv"),
                        resultSet.getString("cnyelv")));
            }
            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Nem lehet csatlakozni az adatbázishoz!");
        }
    }
}

package graduateproject;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

public class CitiesDao {
    public static final String ERROR_CONNECT_CITIES = "Can't connect to CITIES data table!";
    public static final String ERROR_READ_CITIES = "Can't read from CITIES data table!";

    private DataSource source;

    public CitiesDao(DataSource source) {
        this.source = source;
    }

    public void initializeDao(BufferedReader reader) throws IOException {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "TRUNCATE TABLE cities");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `cities` (`zip`, `city`) VALUES (?, ?)")) {

            statement.executeUpdate();
            insertCities(reader, preparedStatement);

        } catch (SQLException e) {
            throw new IllegalStateException("Insertion has failed!", e);
        }
    }

    private void insertCities(BufferedReader reader, PreparedStatement preparedStatement) throws IOException, SQLException {
        String oneLine;
        while ((oneLine = reader.readLine()) != null) {
            String[] parts = oneLine.split(";");
            if (parts.length > 1) {
                preparedStatement.setString(1, parts[0]);
                preparedStatement.setString(2, parts[1]);
                preparedStatement.executeUpdate();
            }
        }
    }

    public String getCityDao(String zip) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT `city` FROM `cities` WHERE zip=?")) {

            statement.setString(1, zip);
            return getResult(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(ERROR_CONNECT_CITIES, e);
        }
    }

    private String getResult(PreparedStatement statement) {
        try (ResultSet result = statement.executeQuery()) {
            StringBuilder cities = new StringBuilder();
            while (result.next()) {
                cities.append(result.getString("city"));
                cities.append(";");
            }
            if (cities.length() > 0) {
                cities.deleteCharAt(cities.length() - 1);
            }
            return cities.toString();
        } catch (SQLException e) {
            throw new IllegalStateException(ERROR_READ_CITIES, e);
        }
    }
}

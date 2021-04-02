package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    private DataSource source;

    public DogTypes(DataSource source) {
        this.source = source;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT LOWER(name) AS name FROM dog_types WHERE LOWER(country)=LOWER(?) ORDER BY name")) {

            preparedStatement.setString(1, country);
            return getNames(preparedStatement);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    private List<String> getNames(PreparedStatement preparedStatement) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
            return names;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot read from the database!", e);
        }
    }
}

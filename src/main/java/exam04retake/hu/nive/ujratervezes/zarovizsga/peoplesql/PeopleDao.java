package exam04retake.hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {
    DataSource source;

    public PeopleDao(DataSource source) {
        this.source = source;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT ip_address FROM people WHERE first_name=? AND last_name=?")) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            return gerResult(statement);

        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to the database", e);
        }
    }

    private String gerResult(PreparedStatement statement) {
        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.first()) {
                return resultSet.getString("ip_address");
            }
            throw new IllegalArgumentException("Can't fin this person!");

        } catch (SQLException e) {
            throw new IllegalStateException("Can't read from datatable", e);
        }
    }
}

package exam04retake2.hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {
    private DataSource source;

    public HouseCup(DataSource source) {
        this.source = source;
    }

    public int getPointsOfHouse(String houseName) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT SUM(points_earned) as total FROM house_points WHERE house_name=?")) {

            statement.setString(1, houseName);
            return getResult(statement);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    private int getResult(PreparedStatement statement) {
        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.first()) {
                return resultSet.getInt("total");
            }
            throw new IllegalStateException("There is no such house!");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot read from datatable!", e);
        }
    }
}

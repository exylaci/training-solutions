package activitytracker;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    DataSource source;

    public ActivityDao(DataSource source) {
        this.source = source;
    }

    public void createTable() {
//        Flyway flyway = Flyway.configure().locations("activitytracker").dataSource(source).load();
        Flyway flyway = Flyway.configure().dataSource(source).load();
        flyway.clean();
        flyway.migrate();

//        try (Connection conn = source.getConnection();
//             Statement statement = conn.createStatement();
//        ) {
//            statement.executeQuery("DROP DATABASE IF EXISTS `activity_tracker`;");
//            statement.executeQuery("CREATE DATABASE if NOT EXISTS activity_tracker DEFAULT CHARACTER SET UTF8 COLLATE UTF8_HUNGARIAN_CI;");
//            statement.executeQuery("USE activity_tracker;");
//            statement.executeQuery("DROP TABLE IF EXISTS activity;");
//            statement.executeQuery("CREATE TABLE activity (id INT PRIMARY KEY AUTO_INCREMENT, start_time TIMESTAMP, description VARCHAR(255), activity_type VARCHAR(210));");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot create dataTable into the database!", e);
//        }
    }

    public Activity saveActivity(Activity activity) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO activity (start_time,description,activity_type) VALUES(?,?,?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            // statement.setString(1, dataTableName);
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDecription());
            statement.setString(3, activity.getType().name());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            result.next();
            return new Activity(result.getInt("id"), activity);

        } catch (SQLException e) {
            throw new IllegalStateException("Can't insert data into the database!", e);
        }
    }

    public Activity findActivityById(int id) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM activity WHERE id=?")) {

            statement.setInt(1, id);
            return executeTheSelection(statement);

        } catch (SQLException e) {
            throw new IllegalStateException("Can't read from the database!", e);
        }
    }

    private Activity executeTheSelection(PreparedStatement statement) throws SQLException {
        try (ResultSet result = statement.executeQuery()) {
            if (result.next()) {
                return new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("description"),
                        Type.valueOf(result.getString("activity_type")));
            }
            throw new IllegalArgumentException("Can't find it!");
        }
    }

    public List<Activity> listActivities() {
        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement()) {

            List<Activity> activities = new ArrayList<>();
            ResultSet result = statement.executeQuery("SELECT * FROM activity");
            while (result.next()) {
                activities.add(new Activity(
                        result.getInt("id"),
                        result.getTimestamp("start_time").toLocalDateTime(),
                        result.getString("description"),
                        Type.valueOf(result.getString("activity_type"))));
            }
            return activities;

        } catch (SQLException e) {
            throw new IllegalStateException("Can't import from the database!", e);
        }
    }
}

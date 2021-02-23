package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private List<Activity> activities = new ArrayList<>();

    public static void main(String[] args) {

        ActivityTrackerMain a = new ActivityTrackerMain();

        a.fillUpActivitiList();

        MariaDbDataSource source;
        try {
            source = new MariaDbDataSource();
            source.setUrl("jdbc:mariadb://localhost:3306/activity_tracker?useUnicode=true");
            source.setUser("felhasznaloneve");
            source.setPassword("jelszo");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot create data source!", e);
        }

        ActivityDao dao = new ActivityDao(source);
        dao.createTable();

        a.insertActivities(dao);

        Activity activity = a.findActivity(2, dao);
        System.out.println(activity);

        List<Activity> result = a.loadActivities(dao);
        System.out.println(result);

    }

    private void fillUpActivitiList() {
        activities.add(new Activity(LocalDateTime.of(2020, 1, 1, 0, 0),
                "Bükk bejárása",
                Type.HIKING));
        activities.add(new Activity(LocalDateTime.of(2020, 12, 31, 23, 59),
                "Mátra kijárása",
                Type.HIKING));
        activities.add(new Activity(LocalDateTime.of(2020, 6, 30, 12, 0),
                "Legurulás a Kékesről.",
                Type.BIKING));
        activities.add(new Activity(LocalDateTime.of(2021, 2, 28, 1, 0),
                "Street ball championship.",
                Type.BASKETBALL));
    }

    private void insertActivities(ActivityDao dao) {
        for (Activity activity : activities) {
            dao.saveActivity(activity);
        }
    }

    private Activity findActivity(int id, ActivityDao dao) {
        return dao.findActivityById(id);
    }

    private List<Activity> loadActivities(ActivityDao dao) {
        return dao.listActivities();
    }
}

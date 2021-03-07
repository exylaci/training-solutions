package activitytracker;

import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTrackerTest {


    @Test
    void atAllTest() {
        List<TrackPoint> trackPoints = List.of(
                new TrackPoint(1, LocalDate.now(), 47.6, 19.2),
                new TrackPoint(2, LocalDate.now(), 47.7, 17.3),
                new TrackPoint(3, LocalDate.now(), 47.5, 18.1));

        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity(LocalDateTime.of(2020, 1, 1, 0, 0),
                "Bükk bejárása",
                Type.HIKING,
                trackPoints));
        activities.add(new Activity(LocalDateTime.of(2020, 12, 31, 23, 59),
                "Mátra kijárása",
                Type.HIKING,
                trackPoints));
        activities.add(new Activity(LocalDateTime.of(2020, 6, 30, 12, 0),
                "Legurulás a Kékesről.",
                Type.BIKING,
                trackPoints));
        activities.add(new Activity(LocalDateTime.of(2021, 2, 28, 1, 0),
                "Street ball championship.",
                Type.BASKETBALL,
                null));


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

        for (int i = 1; i < 5; ++i) {
            assertEquals(i, dao.saveActivity(activities.get(i - 1)).getId());
        }

        assertEquals("Street ball championship.", dao.findActivityById(4).getDecription());

        assertEquals(1, dao.listActivities().size());

    }
}
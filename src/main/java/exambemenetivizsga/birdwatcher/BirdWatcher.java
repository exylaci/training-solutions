package exambemenetivizsga.birdwatcher;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BirdWatcher {
    private JdbcTemplate jdbcTemplate;

    public BirdWatcher(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
    }

    public List<String> getUniqueBirds() {
        return jdbcTemplate.query(
                "SELECT DISTINCT species FROM birds_spotted ORDER BY species",
                (rs, rowNum) -> rs.getString("species"));
    }
}
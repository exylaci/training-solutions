package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JurassicPark {
    private JdbcTemplate jdbcTemplate;

    public JurassicPark(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> checkOverpopulation() {
        return jdbcTemplate.query(
                "SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed",
                (resultSet, index) -> resultSet.getString("breed"));
    }
}
package gyaxi.kovacseni.zoo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Dao {
    JdbcTemplate jdbcTemplate;

    public Dao(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
    }

    public List<ZooAnimal> loadAnimals() {
        return jdbcTemplate.query("SELECT animal_name, length_of_member, weight, animal_type FROM animals",
                (rs, index) -> new ZooAnimal(
                        rs.getString("animal_name"),
                        rs.getInt("length_of_member"),
                        rs.getLong("weight"),
                        AnimalType.valueOf(rs.getString("animal_type"))));
    }
}
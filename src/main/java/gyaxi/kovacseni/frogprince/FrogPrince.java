package gyaxi.kovacseni.frogprince;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class FrogPrince {
    public Set<PlayerOfTale> getPlayersOfTale(MariaDbDataSource dataSource, Tale tale) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Set<PlayerOfTale> result = new HashSet<>();

        jdbcTemplate.query(
                "SELECT player_name, age FROM tales WHERE tale=?",
                (ResultSet rs) -> {
                    result.add(new PlayerOfTale(
                            rs.getString("player_name"),
                            rs.getInt("age"),
                            tale));
                },
                tale.name());

        return result;
    }
}
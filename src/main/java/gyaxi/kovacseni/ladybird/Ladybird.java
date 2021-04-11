package gyaxi.kovacseni.ladybird;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

public class Ladybird {
    private JdbcTemplate jdbcTemplate;

    public Ladybird(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int dots) {
        return jdbcTemplate.query(
                "SELECT hungarian_name FROM ladybirds WHERE number_of_points=?",
                (rs, index) -> rs.getString("hungarian_name"),
                dots);
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
        Map<Integer, Integer> result = new TreeMap<>();
        jdbcTemplate.query(
                "SELECT number_of_points, COUNT(number_of_points) AS pieces FROM ladybirds GROUP BY number_of_points ORDER BY number_of_points",
                (ResultSet rs) -> {
                    do {
                        result.put(rs.getInt("number_of_points"), rs.getInt("pieces"));
                    } while (rs.next());
                });
        return result;
    }

//    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
//        return jdbcTemplate.query(
//                "SELECT number_of_points, COUNT(number_of_points) AS pieces FROM ladybirds GROUP BY number_of_points ORDER BY number_of_points",
//                (rs, index) -> new Map.Entry<Integer, Integer>() {
//                    private final Integer key = rs.getInt("number_of_points");
//                    private Integer value = rs.getInt("pieces");
//
//                    @Override
//                    public Integer getKey() {
//                        return key;
//                    }
//
//                    @Override
//                    public Integer getValue() {
//                        return value;
//                    }
//
//                    @Override
//                    public Integer setValue(Integer value) {
//                        return value;
//                    }
//                })
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
//    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String namePart, int dot) {
        Set<Ladybug> result = new HashSet<>();
        jdbcTemplate.query("""
                        SELECT hungarian_name, latin_name, genus, number_of_points
                            FROM ladybirds
                            WHERE latin_name LIKE ? AND number_of_points=?""",
                (ResultSet rs) -> {

                    do {
                        result.add(new Ladybug(
                                rs.getString("hungarian_name"),
                                rs.getString("latin_name"),
                                rs.getString("genus"),
                                rs.getInt("number_of_points")));
                    } while (rs.next());
                },
                "%" + namePart + "%", dot
        );
        return result;
    }

    public Map<String, Integer> getLadybirdStatistics() {
        Map<String, Integer> result = new TreeMap<>();
        jdbcTemplate.query(
                "SELECT genus, COUNT(genus) AS pieces FROM ladybirds GROUP BY genus",
                (ResultSet rs) -> {
                    do {
                        result.put(rs.getString("genus"), rs.getInt("pieces"));
                    } while (rs.next());
                });
        return result;
    }
}
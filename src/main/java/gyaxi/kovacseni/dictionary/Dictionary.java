package gyaxi.kovacseni.dictionary;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Dictionary {
    private JdbcTemplate jdbcTemplate;

    public Dictionary(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
    }

    public String getEnglishWord(String word) {
        List<String> result = jdbcTemplate.query(
                "SELECT angol FROM words WHERE magyar=?",
                (resultSet, rowNumber) -> resultSet.getString("angol"),
                word);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("No such word in dictionary.");
        }
        return result.get(0);
    }

    public String getHungarianWord(String word) {
        List<String> result = jdbcTemplate.query(
                "SELECT magyar FROM words WHERE angol=?",
                (rs, rowNum) -> rs.getString("magyar"),
                word);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("No such word in dictionary.");
        }
        return result.get(0);
    }
}

package gyaxi.kviz;

import org.flywaydb.core.Flyway;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Dao {
    public static final String FLYWAY_MIGRATION_DIRECTORY = "src/main/resources/gyaxi/kviz";

    private JdbcTemplate jdbcTemplate;

    public Dao(DataSource source) {
        jdbcTemplate = new JdbcTemplate(source);
        loadQuestions(source);
    }

    private void loadQuestions(DataSource source) {
        Flyway flyway = Flyway.configure()
                .locations("filesystem:" + FLYWAY_MIGRATION_DIRECTORY).dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }

    public int getPieces() {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT COUNT(id) AS pieces FROM questions",
                    (rs, rowNum) -> rs.getInt("pieces"));
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public Question getQuestion(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT question, answer1, answer2, answer3, answer4 FROM questions WHERE id=?",
                (rs, index) -> new Question(
                        id,
                        rs.getString("question"),
                        rs.getString("answer1"),
                        rs.getString("answer2"),
                        rs.getString("answer3"),
                        rs.getString("answer4")),
                id);
    }
}
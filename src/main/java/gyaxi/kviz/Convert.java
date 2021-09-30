package gyaxi.kviz;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class Convert {
    public static void main(String[] args) {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            source.setUser("employees");
            source.setPassword("employees");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!");
            return;
        }
        JdbcTemplate jdbcTemplate = new JdbcTemplate(source);

        try (BufferedReader reader = Files.newBufferedReader(
                Path.of("src/main/resources/gyaxi/kviz/questions.txt"), StandardCharsets.UTF_8)) {
            String[] lines = new String[6];
            int index = 0;
            jdbcTemplate.update("TRUNCATE questions");
            while ((lines[index] = reader.readLine()) != null) {
                ++index;
                if (index > 5) {
                    jdbcTemplate.update(
                            "INSERT INTO questions(question, answer1, answer2, answer3, answer4) VALUE(?,?,?,?,?)",
                            lines[0].replace("##", "\r\n"),
                            lines[1],
                            lines[2],
                            lines[3],
                            lines[4]);
                    index = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read from file!");
            return;
        }
        System.out.printf("Az adatok betöltve");
    }
}

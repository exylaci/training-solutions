package gyaxi.kovacseni.zooadoption;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    JdbcTemplate jdbcTemplate;

    public void loadAdoptiveParentsFromDatabase(MariaDbDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getTextsOfLetters(String fileName) {
        String template = loadTemplate(fileName);

        return adaptationQuery()
                .stream()
                .map(connection -> fillTemplate(template, connection))
                .collect(Collectors.toList());
    }

    public Adoption getFirstAdoption() {
        return jdbcTemplate.queryForObject(
                """
                        SELECT animal,adoption_date
                        FROM zooadoptions
                        WHERE adoption_date = (SELECT MIN(adoption_date) FROM zooadoptions)""",
                (resultSet, index) -> new Adoption(
                        resultSet.getString("animal"),
                        resultSet.getDate("adoption_date").toLocalDate()));
    }

    public List<String> getAnimalNamesReverseOrdered() {
        return jdbcTemplate.query(
                "SELECT animal FROM zooadoptions ORDER BY animal DESC",
                (resultSet, index) -> resultSet.getString("animal"));
    }

    public Person getExactPerson(String email) {
        return jdbcTemplate
                .query(
                        "SELECT person_name,email FROM zooadoptions WHERE email=?",
                        (resultSet, index) -> new Person(
                                resultSet.getString("person_name"),
                                resultSet.getString("email")),
                        email)
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such person among the adoptive parents!"));
    }

    private String loadTemplate(String fileName) {
        try {
            return Files.readString(
                    Path.of("src/main/resources/gyaxi/kovacseni/zooadoption").resolve(fileName),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Cant read the template file!");
        }
    }

    private List<Connection> adaptationQuery() {
        return jdbcTemplate.query(
                "SELECT animal, adoption_date, person_name, email FROM zooadoptions",
                (resultSet, index) -> new Connection(
                        new Adoption(
                                resultSet.getString("animal"),
                                resultSet.getDate("adoption_date").toLocalDate()),
                        new Person(
                                resultSet.getString("person_name"),
                                resultSet.getString("email")
                        )));
    }

    private String fillTemplate(String template, Connection connection) {
        return template
                .replace("{orokbefogado_szulo}", connection.getPerson().getName())
                .replace("{datum}", "2021-10-04")
                .replace("{idopont}", "17:00")
                .replace("{orokbefogadott_allat}", connection.getAdoption().getAnimal())
                .replace("\r\n", "\n");
    }
}
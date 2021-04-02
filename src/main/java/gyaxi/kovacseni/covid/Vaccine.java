package gyaxi.kovacseni.covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public abstract class Vaccine {
    private List<Person> people = new ArrayList<>();

    protected Vaccine(DataSource source) {
        initialization(source);
    }

    public abstract List<Person> getVaccinationList();

    protected List<Person> getPeople() {
        return people;
    }

    private void initialization(DataSource source) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(source);

        people = jdbcTemplate.query(
                "SELECT person_name, age, chronic_disease, pregnancy FROM registrations",
                (rs, rowNum) -> new Person(
                        rs.getString("person_name"),
                        rs.getInt("age"),
                        ChronicDisease.selectChronicDisease(rs.getString("chronic_disease")),
                        Pregnancy.selectPregnacy(rs.getString("pregnancy"))));
    }
}

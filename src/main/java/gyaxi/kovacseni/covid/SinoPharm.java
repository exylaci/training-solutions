package gyaxi.kovacseni.covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SinoPharm extends Vaccine {
    private JdbcTemplate jdbcTemplate;

    public SinoPharm(DataSource source) {
        super(source);
    }

    @Override
    public List<Person> getVaccinationList() {
        return getPeople()
                .stream()
                .filter(Person::notPregnant)
                .filter(Person::isHealthy)
                .sorted(Comparator.comparing(Person::isYoung).reversed())
                .collect(Collectors.toList());
    }
}
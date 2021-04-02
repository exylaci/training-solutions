package gyaxi.kovacseni.covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pfizer extends Vaccine {
    private JdbcTemplate jdbcTemplate;

    public Pfizer(DataSource source) {
        super(source);
    }

    @Override
    public List<Person> getVaccinationList() {
        return getPeople()
                .stream()
                .sorted(Comparator.comparing(Person::notPregnant).thenComparing(Person::isYoung))
                .collect(Collectors.toList());
    }
}
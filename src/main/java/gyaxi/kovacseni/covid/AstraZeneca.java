package gyaxi.kovacseni.covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AstraZeneca extends Vaccine {
    private JdbcTemplate jdbcTemplate;

    public AstraZeneca(DataSource source) {
        super(source);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> result = getPeople()
                .stream()
                .filter(Person::notPregnant)
                .filter(Person::hasChronicDisease)
                .collect(Collectors.toList());

        result.addAll(getPeople()
                .stream()
                .filter(Person::notPregnant)
                .filter(Person::isHealthy)
                .sorted(Comparator.comparing(Person::isYoung))
                .collect(Collectors.toList()));

        return result;
    }
}
package gyaxi.kovacseni.applicants;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ListByApplicantsPersonal implements ApplicantListGenerator {
    @Override
    public List<Applicant> getListFromDatabase(DataSource source) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(source);

        return jdbcTemplate.query(
                "SELECT  first_name, last_name, phone_number, email FROM  applicants",
                (rs, index) -> new Applicant(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email")));
    }
}

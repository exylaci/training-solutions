package gyaxi.kovacseni.applicants;

import javax.sql.DataSource;
import java.util.List;

public interface ApplicantListGenerator {
    List<Applicant> getListFromDatabase(DataSource source);
}

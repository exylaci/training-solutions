package graduateproject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VaccinationsDao {
    DataSource source;

    public VaccinationsDao(DataSource source) {
        this.source = source;
    }


    public String getVaccine(int id) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT vaccine FROM vaccination WHERE id=?")) {
            preparedStatement.setInt(1, id);
            return getVaccineResult(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to VACCINATIONS data table", e);
        }
    }

    private String getVaccineResult(PreparedStatement preparedStatement) {
        try (ResultSet result = preparedStatement.executeQuery()) {
            if (!result.first()) {
                return "";
            }
            return result.getString("vaccine");
        } catch (SQLException e) {
            throw new IllegalStateException("Can't query from VACCINATIONS data table", e);
        }
    }

}

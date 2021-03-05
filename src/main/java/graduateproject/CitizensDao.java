package graduateproject;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CitizensDao {
    private static final String SEPARATOR = ";";
    private final DataSource source;

    public CitizensDao(DataSource source) {
        this.source = source;
    }

    public void insertCitizenDao(Citizen citizen) {
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)")) {

            statement.setString(1, citizen.getName());
            statement.setString(2, citizen.getZip());
            statement.setInt(3, citizen.getAge());
            statement.setString(4, citizen.getEmail());
            statement.setString(5, citizen.getTaj());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Can't insert into CITIZENS datatable!", e);
        }
    }


    public List<String> insertCitizensFromStreamDao(Scanner scanner, List<String> invalidLines) {
        try (Connection connection = source.getConnection()) {
            connection.setAutoCommit(false);
            doTheInserts(scanner, invalidLines, connection);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to the CITIZENS data table!" + e);
        }
        return invalidLines;
    }

    private void doTheInserts(Scanner scanner, List<String> invalidLines, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO citizens (citizen_name, zip, age, email, taj) " +
                        "VALUES (?,?,?,?,?)")) {
            processLines(scanner, preparedStatement, invalidLines);
            if (!invalidLines.isEmpty()) {
                connection.rollback();
            } else {
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw new IllegalStateException("Data insertion has failed!" + e);
        }
    }

    private void processLines(Scanner scanner, PreparedStatement preparedStatement, List<String> invalidLines) {
        while (scanner.hasNext()) {
            String oneLine = scanner.nextLine();
            if (!oneLine.isBlank()) {
                processOneLine(preparedStatement, invalidLines, oneLine);
            }
        }
    }

    private void processOneLine(PreparedStatement preparedStatement, List<String> invalidLines, String oneLine) {
        Validate validate = new Validate(source);
        Citizen citizen = new Citizen(oneLine);
        if (validate.checkAll(citizen) || isRegistered(citizen.getTaj())) {
            invalidLines.add(oneLine);
        } else {
            insertOneCitizen(preparedStatement, invalidLines, oneLine, citizen);
        }
    }

    private void insertOneCitizen(PreparedStatement preparedStatement, List<String> invalidLines, String oneLine, Citizen citizen) {
        try {
            preparedStatement.setString(1, citizen.getName());
            preparedStatement.setString(2, citizen.getZip());
            preparedStatement.setInt(3, citizen.getAge());
            preparedStatement.setString(4, citizen.getEmail());
            preparedStatement.setString(5, citizen.getTaj());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            invalidLines.add(oneLine);
        }
    }

    public boolean isRegistered(String taj) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT taj FROM citizens WHERE taj=?")) {
            preparedStatement.setString(1, taj);
            return isResult(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to CITIZENS data table", e);
        }
    }

    private boolean isResult(PreparedStatement preparedStatement) {
        try (ResultSet result = preparedStatement.executeQuery()) {
            return result.first();
        } catch (SQLException e) {
            throw new IllegalStateException("Can't query from CITIZENS data table", e);
        }
    }


    public void selectFirst16Dao(String zip, BufferedWriter writer) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT citizen_name, zip, age, email, taj FROM citizens " +
                             "WHERE (zip=? AND ( NUMBER_of_vaccinations=0 OR (NUMBER_of_vaccinations=1 AND last_vacciantion<? ))) " +
                             "ORDER BY number_of_vaccinations DESC, age DESC , citizen_name ASC LIMIT 16")) {
            preparedStatement.setString(1, zip);
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now().minusDays(15)));
            copyResults(writer, preparedStatement);
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Can't connect to the CITIZENS data table!", e);
        }
    }

    private void copyResults(BufferedWriter writer, PreparedStatement preparedStatement) throws SQLException, IOException {
        try (ResultSet result = preparedStatement.executeQuery()) {
            LocalTime time = LocalTime.of(8, 0);

            while (result.next()) {
                writer.write(time.format(DateTimeFormatter.ofPattern("H:mm")));
                writer.write(SEPARATOR);
                writer.write(result.getString("citizen_name"));
                writer.write(SEPARATOR);
                writer.write(result.getString("zip"));
                writer.write(SEPARATOR);
                writer.write(Integer.toString(result.getInt("age")));
                writer.write(SEPARATOR);
                writer.write(result.getString("email"));
                writer.write(SEPARATOR);
                writer.write(result.getString("taj"));
                writer.newLine();
                time = time.plusMinutes(30);
            }
        }
    }


    public int getNumberOfVaccinations(int id) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT number_of_vaccinations FROM citizens WHERE id=?")) {
            preparedStatement.setInt(1, id);
            return getNumberResult(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to CITIZENS data table", e);
        }
    }

    private int getNumberResult(PreparedStatement preparedStatement) {
        try (ResultSet result = preparedStatement.executeQuery()) {
            if (!result.first()) {
                return 0;
            }
            return result.getInt("number_of_vaccinations");
        } catch (SQLException e) {
            throw new IllegalStateException("Can't query from CITIZENS data table", e);
        }
    }


    public void storeSuccessfulVacination(Vaccine vaccine) {
        try (Connection connection = source.getConnection()) {
            connection.setAutoCommit(false);
            insertIntoTables(vaccine, connection);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to vaccinations ore CITIZENS data table", e);
        }
    }

    private void insertIntoTables(Vaccine vaccine, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatementVaccine = connection.prepareStatement(
                "INSERT INTO vaccination (id, vaccination_date, vaccine, result, note) VALUES(?,?,?,?,?)");
             PreparedStatement preparedStatementCitizenNumber = connection.prepareStatement(
                     "UPDATE citizens SET number_of_vaccinations = number_of_vaccinations +1 WHERE id=?");
             PreparedStatement preparedStatementCitizenDate = connection.prepareStatement(
                     "UPDATE citizens SET last_vacciantion = ? WHERE id=?")) {

            preparedStatementVaccine.setInt(1, vaccine.getId());
            preparedStatementVaccine.setDate(2, Date.valueOf(vaccine.getDate()));
            preparedStatementVaccine.setString(3, vaccine.getVaccine());
            preparedStatementVaccine.setString(4, vaccine.getResult());
            preparedStatementVaccine.setString(5, vaccine.getNote());
            preparedStatementVaccine.executeUpdate();

            preparedStatementCitizenNumber.setInt(1, vaccine.getId());
            preparedStatementCitizenNumber.executeUpdate();

            preparedStatementCitizenDate.setDate(1, Date.valueOf(vaccine.getDate()));
            preparedStatementCitizenDate.setInt(2, vaccine.getId());
            preparedStatementCitizenDate.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new IllegalStateException("Can't insert into VACCINATIONS OR CITIZEN data table", e);
        }
    }


    public int getIdByTaj(String taj) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id FROM citizens WHERE taj=?")) {
            preparedStatement.setString(1, taj);
            return doQuery(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't reach CITIZEN data table!", e);
        }
    }

    private int doQuery(PreparedStatement preparedStatement) throws SQLException {
        try (ResultSet result = preparedStatement.executeQuery()) {
            if (result.first())
                return result.getInt("id");
            return -1;
        }

    }


    public void storeFailedVacination(Vaccine vaccine) {
        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vaccination (id, vaccination_date, vaccine, result,note) VALUES(?,?,?,?,?)")) {

            preparedStatement.setInt(1, vaccine.getId());
            preparedStatement.setDate(2, Date.valueOf(vaccine.getDate()));
            preparedStatement.setString(3, vaccine.getVaccine());
            preparedStatement.setString(4, vaccine.getResult());
            preparedStatement.setString(5, vaccine.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Can't insert into VACCINATIONS data table", e);
        }
    }


    public List<String> getReport() {

        try (Connection connection = source.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT COUNT(id) AS pieces, number_of_vaccinations, zip FROM citizens " +
                             "GROUP BY zip, number_of_vaccinations ORDER BY zip")) {

            return prepareReport(resultSet);

        } catch (SQLException e) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<String> prepareReport(ResultSet resultSet) throws SQLException {
        List<String> report = new ArrayList<>();
        String zip = "";
        int[] values = new int[3];
        int index;

        while (resultSet.next()) {
            if (!resultSet.getString("zip").equals(zip)) {
                report.add(String.format("%4s %8d %8d %8d", zip, values[0], values[1], values[2]));
                zip = resultSet.getString("zip");
                values[0] = 0;
                values[1] = 0;
                values[2] = 0;
            }
            index = resultSet.getInt("number_of_vaccinations");
            if (index < 3) {
                values[index] = resultSet.getInt("pieces");
            }
        }

        report.add(String.format("%4s %8d %8d %8d", zip, values[0], values[1], values[2]));
        report.set(0, String.format("%4s %8s %8s %8s oltottak", "irsz", "oltatlan", "1-szer", "2-szer"));

        return report;
    }
}

package graduateproject;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CitizensDaoTest {
    public static MariaDbDataSource source;

    public int getSize() throws SQLException {
        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM citizens");
        result.last();
        int lastIndex = result.getRow();
        result.close();
        statement.close();
        connection.close();

        System.out.println(lastIndex);
        return lastIndex;
    }

    @TempDir
    Path tempDirectory;

    @BeforeAll
    public static void init() {
        try {
            source = new MariaDbDataSource();
            source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
            source.setUser("vaccine");
            source.setPassword("vaccine");
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect to GRADUATE_PROJECT database!", e);
        }
    }

    @BeforeEach
    void prepare() {
        Flyway flyway = Flyway.configure().locations("filesystem:src/test/resources/graduateproject").dataSource(source).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void insertCitizenDao() throws SQLException {
        CitizensDao dao = new CitizensDao(source);
        Citizen citizen = new Citizen("vezetéknév keresztnév;2013;100;a@b.cd;123456782");
        dao.insertCitizenDao(citizen);

        assertEquals(8, getSize());
    }

    @Test
    void insertCitizenDaoTwoTimesInsertWithSameTaj() throws SQLException {
        CitizensDao dao = new CitizensDao(source);
        Citizen citizen = new Citizen("vezetéknév keresztnév;2013;100;a@b.cd;123456782");
        dao.insertCitizenDao(citizen);

        assertThrows(IllegalStateException.class, () -> dao.insertCitizenDao(citizen));

        assertEquals(8, getSize());
    }

    @Test
    void insertCitizensFromStreamCommitDao() throws SQLException {
        Scanner scanner = new Scanner("""
                vezetéknév keresztnév;2021;100;a@b.cd;123456782
                vezetéknév keresztnév;2022;100;a@b.cd;128795710
                """);
        CitizensDao dao = new CitizensDao(source);
        List<String> result = new ArrayList<>();

        result = dao.insertCitizensFromStreamDao(scanner, result);

        System.out.println(result);
        assertEquals(9, getSize());
        assertEquals(0, result.size());
    }

    @Test
    void insertCitizensFromStreamRollbackDao() throws SQLException {
        Scanner scanner = new Scanner("""
                Jó adat;2021;100;a@b.cd;123456782
                duplikált taj adat;2022;100;a@b.cd;123456782
                másik jó adat;2022;100;a@b.cd;128795710
                hibás taj adat;2022;100;a@b.cd;128795711
                """);
        CitizensDao dao = new CitizensDao(source);
        List<String> result = new ArrayList<>();

        result = dao.insertCitizensFromStreamDao(scanner, result);

        assertEquals(7, getSize());
        assertEquals(2, result.size());
    }

    @Test
    void generate() throws SQLException, IOException {
        List<String> errorlog = new ArrayList<>();
        new Logic(source).registrationFromFile("src/test/resources/graduateproject/citizensGroupLoad.csv", errorlog);
        Path path = tempDirectory.resolve("teszt.txt");

        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        new CitizensDao(source).selectFirst16Dao("2021", writer);
        writer.close();

        assertTrue(Files.exists(path));
        assertTrue(Files.size(path) > 500);
    }

    @Test
    void storeSuccessfulVacination() throws IOException, SQLException {
        Vaccine vaccine = new Vaccine();
        vaccine.setId(1);
        vaccine.setVaccine("placebo");
        vaccine.setNote("note into vaccinate data table");
        vaccine.setResult(Logic.SUCCESSFUL);
        vaccine.setDate(LocalDate.of(2000, 12, 31));
        vaccine.setNumberOfVaccinations(100);

        new CitizensDao(source).storeSuccessfulVacination(vaccine);

        assertEquals(Logic.SUCCESSFUL, getResult());
    }

    String getResult() throws SQLException {
        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT result FROM vaccination");
        resultSet.last();
        String temp = resultSet.getString("result");
        resultSet.close();
        statement.close();
        connection.close();

        return temp;
    }

    @Test
    void storeFailedVacination() throws IOException, SQLException {
        Vaccine vaccine = new Vaccine();
        vaccine.setId(1);
        vaccine.setVaccine("placebo");
        vaccine.setNote("note into vaccinate data table");
        vaccine.setResult(Logic.FAILED);
        vaccine.setDate(LocalDate.of(2000, 12, 31));
        vaccine.setNumberOfVaccinations(100);

        new CitizensDao(source).storeSuccessfulVacination(vaccine);

        assertEquals(Logic.FAILED, getResult());
    }

    @Test
    void getReport() throws IOException, SQLException {
        CitizensDao dao = new CitizensDao(source);
        List<String> reesult = dao.getReport();

        assertEquals(4, reesult.size());
        assertEquals("2023        1        0        0 Dunabogdány", reesult.get(1));
        assertEquals("2024        0        1        2 Kisoroszi", reesult.get(2));
        assertEquals("2022        0        2        1 Tahitótfalu, Tahi", reesult.get(3));
    }
}

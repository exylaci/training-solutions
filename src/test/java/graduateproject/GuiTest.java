package graduateproject;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuiTest {

    @Test
    void Registration() throws SQLException {
        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
        source.setUser("vaccine");
        source.setPassword("vaccine");
        Flyway flyway = Flyway.configure().locations("filesystem:src/test/resources/graduateproject").dataSource(source).load();
        flyway.clean();
        flyway.migrate();


        Scanner scanner = new Scanner("vezeték kereszt\n2026\n50\na@b.cd\na@b.cd\n123456782\n6\n");
        Gui gui = new Gui(scanner);
        gui.initialize();
        gui.registration();


        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM citizens");
        result.last();
        Citizen citizen = new Citizen();
        citizen.setName(result.getString("citizen_name"));
        citizen.setZip(result.getString("zip"));
        citizen.setAge(result.getInt("age"));
        citizen.setEmail(result.getString("email"));
        citizen.setTaj(result.getString("taj"));
        int numberOfVaccinations = result.getInt("number_of_vaccinations");
        result.close();
        statement.close();
        connection.close();

        assertEquals("vezeték kereszt", citizen.getName());
        assertEquals("2026", citizen.getZip());
        assertEquals(50, citizen.getAge());
        assertEquals("a@b.cd", citizen.getEmail());
        assertEquals("123456782", citizen.getTaj());
        assertEquals(0, numberOfVaccinations);
    }

    @Test
    void vaccinate() throws SQLException {
        MariaDbDataSource source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
        source.setUser("vaccine");
        source.setPassword("vaccine");
        Flyway flyway = Flyway.configure().locations("filesystem:src/test/resources/graduateproject").dataSource(source).load();
        flyway.clean();
        flyway.migrate();


        Scanner scanner = new Scanner("000000000\n2021\n12\n31\ni\nplacebo\nMegjegyzés? Csak az volt.\n");
        Gui gui = new Gui(scanner);
        gui.initialize();
        gui.vaccinate();


        Connection connection = source.getConnection();
        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM citizens WHERE taj='000000000'");
        result.last();
        int numberOfVaccinations = result.getInt("number_of_vaccinations");
        LocalDate date = result.getDate("last_vacciantion").toLocalDate();
        result.close();

        result = statement.executeQuery("SELECT * FROM vaccination WHERE id=1");
        result.last();
        Vaccine vaccine = new Vaccine();
        vaccine.setDate( result.getDate("vaccination_date").toLocalDate());
        vaccine.setVaccine(result.getString("vaccine"));
        vaccine.setResult(result.getString("result"));
        vaccine.setNote(result.getString("note"));

        result.close();
        statement.close();
        connection.close();

        assertEquals(1,numberOfVaccinations);
        assertEquals(LocalDate.of(2021,12,31),date);

        assertEquals(LocalDate.of(2021,12,31),vaccine.getDate());
        assertEquals("placebo", vaccine.getVaccine());
        assertEquals(Logic.SUCCESSFUL, vaccine.getResult());
        assertEquals("Megjegyzés? Csak az volt.", vaccine.getNote());
    }
}
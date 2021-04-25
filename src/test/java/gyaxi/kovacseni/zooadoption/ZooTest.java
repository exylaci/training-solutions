package gyaxi.kovacseni.zooadoption;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

class ZooTest {

    private Zoo zoo;

    @BeforeEach
    public void setUp() {
        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            Flyway fw = Flyway.configure()
                    .locations("filesystem:src/main/resources/gyaxi/kovacseni/zooadoption")
                    .dataSource(dataSource).load();
            fw.clean();
            fw.migrate();

            zoo = new Zoo();
            zoo.loadAdoptiveParentsFromDatabase(dataSource);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data", sqle);
        }
    }

    @Test
    void testGetTextsOfLetters() {
        List<String> textsOfLetters = zoo.getTextsOfLetters("conferenceforadoptiveparents.txt");

        Assertions.assertEquals("""
                Kedves My Children!

                Nagy szeretettel meghívjuk Önt Állatkertünkbe, az állatainkat
                örökbefogadó szülők első Szülői Értekezletére, melynek dátuma:
                2021-10-04, időpontja: 17:00.
                A szülői értekezleten elmeséljük, hogyan viseli magát mostanság
                az Ön által örökbefogadott Koala, ezáltal Ön is
                egy kicsit betekintést nyerhet a nálunk folyó munkába.

                Örömmel tekintünk a közeli találkozás elé!
                Üdvözlettel: Állatkert""", textsOfLetters.get(12));
    }

    @Test
    void testGetFirstAdoption() {
        Adoption adoption = new Adoption("Galapagos dove", LocalDate.of(2021, 3, 4));

        Assertions.assertEquals(adoption, zoo.getFirstAdoption());
    }

    @Test
    void testGetAnimalNamesReverseOrdered() {
        List<String> animalNamesReverseOrdered = zoo.getAnimalNamesReverseOrdered();

        Assertions.assertEquals("Spotted deer", animalNamesReverseOrdered.get(3));
        Assertions.assertEquals("Egyptian viper", animalNamesReverseOrdered.get(11));
    }

    @Test
    void testGetExactPerson() {
        Person person = new Person("Reginald Trim", "rtrim4@comcast.net");

        Assertions.assertEquals("Reginald Trim", zoo.getExactPerson("rtrim4@comcast.net").getName());
    }

    @Test
    void testGetExactPersonNoSuchPerson() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> zoo.getExactPerson("kiss.jozsef@gmail.com"));
        Assertions.assertEquals("No such person among the adoptive parents!", ex.getMessage());
    }
}
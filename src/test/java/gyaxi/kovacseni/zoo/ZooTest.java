package gyaxi.kovacseni.zoo;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ZooTest {

    private Zoo zoo;

    @BeforeEach
    public void setUp() {
        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            Flyway fw = Flyway.configure()
                    .locations("filesystem:src/main/resources/gyaxi/kovacseni/zoo")
                    .dataSource(dataSource).load();
            fw.clean();
            fw.migrate();

            zoo = new Zoo(dataSource);
            zoo.loadAnimals();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not reach database.", sqle);
        }
    }

    @Test
    public void testAddAnimalThroughGetter() {
        Assertions.assertEquals(13, zoo.getAnimals().size());

        zoo.getAnimals().add(new Lion("Pumba"));

        Assertions.assertEquals(13, zoo.getAnimals().size());
    }

    @Test
    public void testAddAnimal() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        Assertions.assertFalse(zoo.getAnimals().contains(giraffe));
        Assertions.assertEquals(13, zoo.getAnimals().size());

        zoo.addAnimal(giraffe);
        zoo.loadAnimals();

        Assertions.assertTrue(zoo.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zoo.getAnimals().size());
    }

    @Test
    public void testAddAnimalTwice() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        Assertions.assertFalse(zoo.getAnimals().contains(giraffe));
        Assertions.assertEquals(13, zoo.getAnimals().size());

        zoo.addAnimal(giraffe);
        zoo.loadAnimals();

        Assertions.assertTrue(zoo.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zoo.getAnimals().size());

        zoo.addAnimal(giraffe);
        zoo.loadAnimals();

        Assertions.assertTrue(zoo.getAnimals().contains(giraffe));
        Assertions.assertEquals(14, zoo.getAnimals().size());
    }

    @Test
    public void testGetHeaviestAnimalInTheZoo() {
        ZooAnimal elephant = new Elephant("Ambassador", 2, 6500);

        Assertions.assertEquals(elephant, zoo.getHeaviestAnimalInTheZoo());
    }

    @Test
    public void testCountWeights() {
        Assertions.assertEquals(13800, zoo.countWeights());
    }

    @Test
    public void testFindExactAnimal() {
        ZooAnimal lion = new Lion("Aaliyah");

        Assertions.assertEquals(lion, zoo.findExactAnimal(new Lion("Aaliyah")));
    }

    @Test
    public void testFindExactAnimalNotExisting() {
        ZooAnimal elephant = new Elephant("Ola", 2, 5679);

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimal(elephant));
        Assertions.assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    public void testFindExactAnimalByName() {
        ZooAnimal elephant = new Elephant("Serafina", 1, 3100);

        Assertions.assertEquals(elephant, zoo.findExactAnimalByName("Serafina"));
    }

    @Test
    public void testFindExactAnimalByNameNotExisting() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimalByName("xyz"));
        Assertions.assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    public void testGetNumberOfAnimals() {
        Assertions.assertEquals(13, zoo.getNumberOfAnimals());
    }

    @Test
    public void testGetAnimalsOrderedByName() {
        List<ZooAnimal> zooAnimals = zoo.getAnimalsOrderedByName();

        Assertions.assertEquals("Aaliyah", zooAnimals.get(0).getName());
        Assertions.assertEquals("Diana", zooAnimals.get(3).getName());
        Assertions.assertEquals("Simba", zooAnimals.get(9).getName());
    }

    @Test
    public void testGetAnimalStatistics() {
        Map<AnimalType, Integer> statistics = zoo.getAnimalStatistics();

        Assertions.assertEquals(6, statistics.get(AnimalType.LION));
        Assertions.assertEquals(4, statistics.get(AnimalType.GIRAFFE));
        Assertions.assertEquals(3, statistics.get(AnimalType.ELEPHANT));
    }
}

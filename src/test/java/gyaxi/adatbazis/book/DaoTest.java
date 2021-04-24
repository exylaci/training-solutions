package gyaxi.adatbazis.book;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {
    static MariaDbDataSource dataSource;
    static Dao dao;
    static JdbcTemplate jdbcTemplate;

    @BeforeAll
    static void initialize() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        dao = new Dao(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @BeforeEach
    void prepare() {
        Flyway flyway = Flyway
                .configure()
                .locations("filesystem:src/test/resources/gyaxi/adatbazis/book")
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();
    }


    @Test
    void oldestPublisher() {
        PublisherCompany publisherCompany = dao.getOldestCompany();

        assertEquals("Európa Könyvkiadó", publisherCompany.getName());
        assertEquals("2040 Budaörs, Ébner György köz 4. fszt. 2.", publisherCompany.getAddress());
        assertEquals("info@europakiado.hu", publisherCompany.getEmail());
        assertEquals(LocalDate.of(1846, 2, 23), publisherCompany.getEstablish());
    }

    @Test
    void email() {
        assertEquals("kolibri@kolibrikiado.hu", dao.getEmail());
    }

    @Test
    void booksFromACity() {
        List<Book> books = dao.getBooksFromACity("Budaörs");
        Book book = books.stream().filter(b -> b.getId() == 12).findAny().get();

        assertEquals(10, books.size());
        assertEquals("Charles Eisenstein", book.getAuthor());
        assertEquals("Klíma - Átfogó megoldások egy élhető jövőért", book.getTitle());
        assertEquals(2767.4, book.getPrice(), 0.001);
    }

    @Test
    void booksFromAnotherCity() {
        List<Book> books = dao.getBooksFromACity("Ököritófülpös");

        assertEquals(0, books.size());
    }

    @Test
    void newBook() {
        int id = dao.newBook(new Book("author", "title", 12.5, 1));

        assertEquals(50, id);

        Book book = jdbcTemplate.queryForObject(
                "SELECT id,author,title,price,publisher FROM books WHERE id=50",
                (rs, index) -> new Book(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getDouble("price"),
                        rs.getInt("publisher")));
        assertEquals("author", book.getAuthor());
        assertEquals("title", book.getTitle());
        assertEquals(12.5, book.getPrice());
        assertEquals(1, book.getPublisherId());
    }

    @Test
    void acquisition() {
        boolean successfull = dao.acquisition("Anonymus kiadó", "Park könyvkiadó");

        assertTrue(successfull);

        List<Integer> ids = jdbcTemplate.query("SELECT id FROM publishers WHERE company='Park könyvkiadó'",
                (rs, index) -> rs.getInt("id"));

        assertEquals(0, ids.size());
    }

    @Test
    void acquisition2() {
        assertFalse(dao.acquisition("Nemlétező kiadó", "Park könyvkiadó"));
    }

    @Test
    void acquisition3() {
        assertFalse(dao.acquisition("Park könyvkiadó", "Nemlétező kiadó"));
    }

    @Test
    void priceIncreasing1() {
        assertTrue(dao.priceIncreasing(3, "Jelenkor Könyvkiadó"));

        List<Double> ids = jdbcTemplate.query("SELECT price FROM books ORDER BY id",
                (rs, index) -> rs.getDouble("price"));

        assertEquals(2467.5, ids.get(1), 0.00001);
        assertEquals(7401, ids.get(27), 0.00001);
        assertEquals(6728.1, ids.get(39), 0.00001);
    }

    @Test
    void priceIncreasing2() {
        assertFalse(dao.priceIncreasing(3, "nem létező kiadó"));
    }
}
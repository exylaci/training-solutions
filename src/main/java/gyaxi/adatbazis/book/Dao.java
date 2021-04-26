package gyaxi.adatbazis.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class Dao {
    private final JdbcTemplate jdbcTemplate;

    public Dao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PublisherCompany getOldestCompany() {
        return jdbcTemplate.queryForObject("""
                        SELECT id,company,address,email,establish
                        FROM publishers
                        WHERE establish = (SELECT min(establish) FROM publishers)""",
                (rs, index) -> new PublisherCompany(
                        rs.getInt("id"),
                        rs.getString("company"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getDate("establish").toLocalDate()
                ));
    }

    public String getEmail() {
        return jdbcTemplate.queryForObject("""
                        SELECT email FROM publishers
                        JOIN books ON books.publisher=publishers.id
                        WHERE LENGTH(title) = (SELECT max(length(title)) FROM books)""",
                (rs, index) -> rs.getString("email"));
    }

    public List<Book> getBooksFromACity(String city) {
        return jdbcTemplate.query("""
                        SELECT books.id,author,title,price,publisher FROM books
                            JOIN publishers ON books.publisher = publishers.id
                            where publisher IN (SELECT id FROM publishers WHERE address LIKE ?)""",
                (rs, index) -> new Book(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getDouble("price"),
                        rs.getInt("publisher")),
                "%" + city + "%");
    }

    public int newBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO books(author,title,price,publisher) VALUE(?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, book.getAuthor());
                    preparedStatement.setString(2, book.getTitle());
                    preparedStatement.setDouble(3, book.getPrice());
                    preparedStatement.setInt(4, book.getPublisherId());
                    return preparedStatement;
                },
                keyHolder);

        return (int) keyHolder.getKey().longValue();
    }

    public boolean acquisition(String acquisitor, String acquisited) {
        List<Integer> ids = isCompaniesExist(acquisitor, acquisited);
        if (ids.size() != 2) {
            return false;
        }

        setPublisherToAcquisitor(acquisitor, acquisited);
        deleteAcquisited(acquisited);
        return true;
    }

    private void deleteAcquisited(String acquisited) {
        jdbcTemplate.update("DELETE FROM publishers WHERE company=?",
                acquisited);
    }

    private void setPublisherToAcquisitor(String acquisitor, String acquisited) {
        jdbcTemplate.update("""
                        UPDATE books 
                        SET publisher = (SELECT id FROM publishers WHERE company=?)
                        WHERE publisher = (SELECT id FROM publishers WHERE company=?)""",
                acquisitor, acquisited);
    }

    private List<Integer> isCompaniesExist(String acquisitor, String acquisited) {
        return jdbcTemplate.query(
                "SELECT id FROM publishers WHERE company=? OR company=?",
                (rs, index) -> rs.getInt("id"),
                acquisitor, acquisited);
    }

    public boolean priceIncreasing(int inflation, String publisher) {
        List<Integer> ids = isCompaniesExist(publisher, publisher);
        if (ids.size() != 1) {
            return false;
        }

        jdbcTemplate.update("""
                        UPDATE books,publishers SET price = price * ?
                        WHERE company=? AND books.publisher = publishers.id""",
                inflation, publisher);
        return true;
    }
}

package gyaxi.kovacseni.frogprince;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Set;

public class FrogPrinceTest {

    private MariaDbDataSource dataSource;

    @BeforeEach
    public void setUp() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }

        Flyway fw = Flyway.configure()
                .locations("filesystem:src/main/resources/gyaxi/kovacseni/frogprince")
                .dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void getPlayersOfTale() {
        Set<PlayerOfTale> playersOfTale = new FrogPrince().getPlayersOfTale(dataSource, Tale.FROGPRINCE);

        Assertions.assertTrue(playersOfTale.contains(new PlayerOfTale("Békakirályfi", 27, Tale.FROGPRINCE)));
        Assertions.assertTrue(playersOfTale.contains(new PlayerOfTale("Kicsi királykisasszony", 21, Tale.FROGPRINCE)));
        Assertions.assertFalse(playersOfTale.contains(new PlayerOfTale("Hófehérke", 23, Tale.SNOWWHITE)));
        Assertions.assertFalse(playersOfTale.contains(new PlayerOfTale("Piroska", 9, Tale.LITTLEREDRIDINGHOOD)));
    }
}
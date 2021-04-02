package erettsegik.oktober2019.forditoiroda;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {
    static MariaDbDataSource source;
    static Logic logic;
    static Flyway flyway;

    @BeforeAll
    static void init() throws SQLException {
        source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/forditoiroda?useUnicode=true");
        source.setUser("erettsegik");
        source.setPassword("erettsegik");

        logic = new Logic(source, "filesystem:src/main/resources/erettsegik/oktober2019/forditoiroda");
        flyway = Flyway
                .configure()
                .locations("filesystem:src/test/resources/erettsegik/oktober2019/forditoiroda")
                .dataSource(source)
                .load();
    }

    @BeforeEach
    void prepare() {
        flyway.clean();
        flyway.migrate();
    }

//    @Test
//    void excercrise1() {
//        System.out.println("Müxik");
//    }

    @Test
    void excercrise2() {
        assertEquals("Falch Emil, Forrai Laura, Gál Brigitta, Kiss Lajos, Nagy Tímea, Rácz Lili, Samu Blanka, Siket Karen, Szabó Orsolya Virág, Szilágyi István, Zsolnai Péter",
                String.join(", ", logic.exercrise2()));
    }
    @Test
    void excercrise3() {
        ReportData result = logic.exercrise3();

        assertEquals(3,result.getPieces());
        assertEquals(18000,result.getAmount());
    }

    @Test
    void exercrise4(){
        List<ReportData> result = logic.exercrise4();

        assertEquals(20,result.size());
        assertEquals(148592,result.get(0).getSize());
        assertEquals("irodalom",result.get(19).getSubject());
    }

    @Test
    void exercrise5(){
        assertEquals(30,logic.exercrise5().size());
    }

    @Test
    void excercrise6() {
        assertTrue(List.of("Horváth Mercédesz","Dombovári Petra").contains( logic.exercrise6()));
    }

    @Test
    void excercrise7() {
        assertEquals("Kiss Lajos", logic.exercrise7().get(0));
    }

    @Test
    void excercrise8() {

    assertEquals(102,logic.exercrise8().size());
    }
}


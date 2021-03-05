package graduateproject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidateTest {

    public static Validate validate;

    @BeforeAll
    public static void initialize() throws SQLException {
        MariaDbDataSource source;
        source = new MariaDbDataSource();
        source.setUrl("jdbc:mariadb://localhost:3306/graduate_project?useUnicode=true");
        source.setUser("vaccine");
        source.setPassword("vaccine");
        validate = new Validate(source);
    }


    @Test
    void CheckName() {
        assertTrue(validate.checkName(""));
        assertTrue(validate.checkName(" "));
        assertTrue(validate.checkName("a"));
        assertFalse(validate.checkName("a b"));
    }

    @Test
    void CheckZip() {
        assertTrue(validate.checkZip(""));
        assertTrue(validate.checkZip("0000"));
        assertFalse(validate.checkZip("2021"));
        assertFalse(validate.checkZip("4128"));
    }


    @Test
    void CheckAge() {
        assertTrue(validate.checkAge("10"));
        assertTrue(validate.checkAge("150"));
        assertFalse(validate.checkAge("11"));
        assertFalse(validate.checkAge("149"));
    }

    @Test
    void CheckEmail() {
        assertTrue(validate.checkEmail(""));
        assertTrue(validate.checkEmail(" "));
        assertTrue(validate.checkEmail("a"));
        assertTrue(validate.checkEmail("a@"));
        assertTrue(validate.checkEmail("@a"));
        assertTrue(validate.checkEmail("@a.bc"));
        assertTrue(validate.checkEmail(".@a.bc"));
        assertTrue(validate.checkEmail("a.@a.bc"));
        assertTrue(validate.checkEmail(".a@a.bc"));
        assertTrue(validate.checkEmail("a@.a.bc"));
        assertTrue(validate.checkEmail("a@b."));
        assertTrue(validate.checkEmail("a@b.c"));
        assertTrue(validate.checkEmail("a@b.cdefgh"));
        assertFalse(validate.checkEmail("a@b.cd"));
        assertFalse(validate.checkEmail("a@b.cdef"));
        assertFalse(validate.checkEmail("a.b@c.d.ef"));
    }

    @Test
    void TestCheckTaj() {
        assertTrue(validate.checkTaj("         "));
        assertTrue(validate.checkTaj("aaaaaaaaa"));
        assertTrue(validate.checkTaj("12345678"));
        assertTrue(validate.checkTaj("1234567880"));
        assertFalse(validate.checkTaj("020202024"));
        assertFalse(validate.checkTaj("202020206"));
        assertFalse(validate.checkTaj("123456782"));
        assertFalse(validate.checkTaj("128795710"));
    }
}

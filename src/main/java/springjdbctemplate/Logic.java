package springjdbctemplate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class Logic {

    private Dao dao;

    public static void main(String[] args) {
        MariaDbDataSource source = new MariaDbDataSource();
        try {
            source.setUrl("jdbc:mariadb://localhost:3306/forditoiroda?useUnicode=true");
            source.setUser("erettsegik");
            source.setPassword("erettsegik");
        } catch (SQLException e) {
            System.out.println("Cannot connect to the database!" + e);
        }
        Logic logic=new Logic();
        logic.dao=new Dao(source);

        System.out.println(logic.dao.getSomething());
    }
}
package springjdbctemplate;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Dao {
    private JdbcTemplate jdbcTemplate;

    public Dao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public String getSomething() {
//        System.out.println((String) jdbcTemplate.queryForObject("""
//                        SELECT nev
//                            FROM fordito
//                                JOIN nyelv ON nyelvid=nyelv.id
//                                JOIN szemely ON szemelyid=szemely.id
//                            WHERE fnyelv='magyar'
//                            GROUP BY nev
//                            ORDER BY COUNT(cnyelv) DESC
//                            LIMIT 1""",
//                new Object[]{},                   //ez már nem kell bele
//                (rs, rowNum) -> rs.getString("nev")));
        String resultString = jdbcTemplate.queryForObject("""
                        SELECT nev
                            FROM fordito
                                JOIN nyelv ON nyelvid=nyelv.id
                                JOIN szemely ON szemelyid=szemely.id
                            WHERE fnyelv='magyar'
                            GROUP BY nev
                            ORDER BY COUNT(cnyelv) DESC
                            LIMIT 1""",
                (rs, rowNum) -> rs.getString("nev"));

        List<String> resultList = jdbcTemplate.query("""
                        SELECT nev
                            FROM fordito
                                JOIN nyelv ON nyelvid=nyelv.id
                                JOIN szemely ON szemelyid=szemely.id
                            WHERE fnyelv='magyar'
                            GROUP BY nev
                            ORDER BY COUNT(cnyelv) DESC""",
                (rs, rowNum) -> rs.getString("nev"));

        System.out.println(resultList);


        return resultString;

        //   src/main/resources/logback.xml
        //<configuration>
        //
        //    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        //        <!-- encoders are assigned the type
        //             ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
        //        <encoder>
        //            <pattern>%d{HH:mm:ss.SSS}%-5level %logger{36} - %msg%n</pattern>
        //        </encoder>
        //    </appender>
        //    <logger name="org.flywaydb" level="ERROR" />
        //    <root level="error">                              //error | debug szabályozza mennyit írjon ki
        //        <appender-ref ref="STDOUT" />
        //    </root>
        //</configuration>
    }
}

package gyaxi.kovacseni.vaccination;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class VaccinationListTest {

    private VaccinationList list;

    @BeforeEach
    public void setUp() {
        list = new VaccinationList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(VaccinationListTest.class.getResourceAsStream("vaccinationlist_2021-03-02_1234.csv")))) {
            list.readFromFile(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    @Test
    public void testSetUp() {
        Assertions.assertEquals(16, list.getVaccinations().size());
        Assertions.assertEquals("1234", list.getMetaData().getPostalCode());
        Assertions.assertEquals("Kukutyin", list.getMetaData().getTownName());
        Assertions.assertEquals(LocalDate.of(2021, 3, 2), list.getMetaData().getDate());
    }

    @Test
    public void testGetPersonsMoreThanHundredYearsOld() {
        Assertions.assertEquals(11, list.getPersonsMoreThanHundredYearsOld().size());
        Assertions.assertEquals("Lurlene Dunphie", list.getPersonsMoreThanHundredYearsOld().get(3).getName());
        Assertions.assertEquals(116, list.getPersonsMoreThanHundredYearsOld().get(5).getAge());
    }

    @Test
    public void testGetAfternoonPersons() {
        Assertions.assertEquals(7, list.getAfternoonPersons().size());
        Assertions.assertEquals("Benny Wallis", list.getAfternoonPersons().get(1).getName());
        Assertions.assertEquals(72, list.getAfternoonPersons().get(4).getAge());
    }

    @Test
    public void testValidateTaj() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> list.validateTaj());
        Assertions.assertEquals("787340842, 190339732, ", ex.getMessage());
    }

    @Test
    public void testInviteExactPerson() {
        Assertions.assertEquals("Kedves Evie Waddams! Ön következik. Kérem, fáradjon be!", list.inviteExactPerson(LocalTime.of(13, 30)));
    }

    @Test
    public void testGetTown() {
        Assertions.assertEquals("1234, Kukutyin", list.getTown().toString());
    }

    @Test
    public void testGetDateOfVaccination() {
        Assertions.assertEquals(LocalDate.of(2021, 3, 2), list.getDateOfVaccination());
    }

    @Test
    public void testGetVaccinationStatistics() {
        Map<VaccinationType, Integer> expected = list.getVaccinationStatistics();

        Assertions.assertEquals(9, expected.get(VaccinationType.NONE));
        Assertions.assertEquals(3, expected.get(VaccinationType.PFIZER));
    }
}

package gyaxi.kovacseni.zooadoption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class AdoptionTest {

    @Test
    void testCreate() {
        Adoption adoption = new Adoption("Kék bálna", LocalDate.of(2021, 4, 22));

        Assertions.assertEquals("Kék bálna", adoption.getAnimal());
        Assertions.assertEquals(LocalDate.of(2021, 4, 22), adoption.getAdoptionDate());
    }
}
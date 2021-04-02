package gyaxi.kovacseni.dogs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DogTest {

    @Test
    void testCreate() {
        Dog dog = new Dog("PULI", "HUNGARY", "http://www.fci.be/en/nomenclature/PULI-55.html");

        Assertions.assertEquals("PULI", dog.getName());
        Assertions.assertEquals("HUNGARY", dog.getCountry());
        Assertions.assertEquals("http://www.fci.be/en/nomenclature/PULI-55.html", dog.getUrl());
    }
}

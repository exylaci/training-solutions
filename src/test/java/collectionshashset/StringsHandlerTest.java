package collectionshashset;

import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringsHandlerTest {

    @Test
    public void checkNumberOfElementsInSet() {
        Collection<String> testCollection = new RandomStringGenerator().createStrings(4, 500_000);

        //When
        Set<String> strings = new RandomStringGenerator().filterUniqueStrings(testCollection);

        //Then
        assertTrue(strings.size() < testCollection.size());
    }

    @Test
    public void checkNumberOfIdenticalElementsInSets() {
        //Given
        Set<String> strings = new HashSet<>(new RandomStringGenerator().createStrings(4, 500_000));
        Set<String> anotherStrings = new HashSet<>(new RandomStringGenerator().createStrings(4, 500_000));
        int a = strings.size();
        int b = anotherStrings.size();

        //When
        strings = new RandomStringGenerator().selectIdenticalStrings(strings, anotherStrings);

        //Then
        assertTrue(strings.size() < (a + b));
    }
}
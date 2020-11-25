package week05.d3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    void listMergerTest(){
        assertEquals("0", new ListCounter().listMerger(null));
        assertEquals("0", new ListCounter().listMerger( Arrays.asList()));
        assertEquals("Aliangyal", new ListCounter().listMerger(Arrays.asList("Ali",null,"Baba","","egy","angyal")));
    }
}
//Írj egy olyan metódust az week05d03.ListCounter osztályban, mely
// egy kapott Listából (String) összeszámolja azokat amik 'a' vagy 'A' betűvel kezdődnek,
//Ha nulla elemű a tömb,vagy nincs benne ilyen elem, akkor 0-t adjon vissza. (edited)
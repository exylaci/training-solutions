package week05.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teszt {

    @Test
    public void teszt() {

        List<String> list = Arrays.asList("foo", "bar");
// Az első két lista csak azért egyenlő, mert ugyanazokat a sztring literálokat tartalmazza a sztring pool-ból.
// Gyakorlatilag nem hozott létre másik új lista objektumot.
        assertEquals(list,
                Arrays.asList("foo", "bar"));
// Ha már új sztringet hozatunk létre a sztring poolban, akkor már ezek sem egyenlők.
        assertNotEquals(list,
                Arrays.asList("foo", new String[]{"bar"}));


// "Mind a két listában" ugyanazt az egy Minta objektum van, ezért nem jön létre új lista sem.
// Vagyis saját magával hasonlítja össze.
        Minta minta = new Minta("Valaki", 10);
        List<Minta> l1 = Arrays.asList(minta);
        List<Minta> l2 = Arrays.asList(minta);
        assertEquals(
                l1,
                l2);

// A .add() miatt elkezdenének önnáló életet élni,  viszont az Array.asList() -tel létrehozott lista nem módosítható!!!
//      l1.add(minta);


// Látszatra mind a két listában ugyanaz az egy Minta objektum, de a valóságban a new -val újabb Minta objektumot hozunk létre.
        List<Minta> list1 = new ArrayList<>();
        list1.add(new Minta("Valaki", 10));
        List<Minta> list2 = new ArrayList<>();
        list2.add(new Minta("Valaki", 10));

        assertNotEquals(
                list1,
                list2);
    }
}

package dateduration;

import java.time.Duration;
import java.time.LocalTime;

public class StringCreationStudies {
    public long measureStringCreationTimeRequiredOnHeap(int objectsCount) {
        LocalTime start = LocalTime.now();
        for (int i = 0; i < objectsCount; ++i) {
            String s = Integer.toString(i);
        }
        LocalTime stop = LocalTime.now();
        return Duration.between(start, stop).toNanos();
    }

    public long measureStringCreationTimeRequiredInPool(int objectsCount) {
        LocalTime start = LocalTime.now();
        for (int i = 0; i < objectsCount; ++i) {
            String s = Integer.toString(i).intern();
        }
        LocalTime stop = LocalTime.now();
        return Duration.between(start, stop).toNanos();
    }

    public static void main(String[] args) {
        final int repeat = 1000000;

        long heap = new StringCreationStudies().measureStringCreationTimeRequiredOnHeap(repeat);
        long pool = new StringCreationStudies().measureStringCreationTimeRequiredInPool(repeat);

        System.out.println("Heapben: " + heap);
        System.out.println("Poolban: " + pool);
        System.out.println("viszony: " + pool / heap + " -szeres");
    }
}
//A feladat inkább egy tanulmány, mint tipikus alkalmazás. Tudjuk, hogy a String objektumok kétféle módon és helyen
// jöhetnek létre, ezek eltérő időigényűek is. Próbáljuk ki ezt a gyakorlatban is, a Duration és az Instant objektumok
// segítségével. Hozzuk létre a StringCreationStudies osztályt. Két, azonos felépítésű metódus készül, az egyikben a
// heap-re, a másikban a pool-ba gyártunk nagyszámú, azonos String objektumokat.
//
//Megvalósítási javaslatok
//publikus metódusok:
//  public long measureStringCreationTimeRequiredOnHeap(int objectsCount)
//  public long measureStringCreationTimeRequiredInPool(int objectsCount)
//
//Megjegyzés
//Értékelhető különbség csak nagyszámú objektum esetében jön ki! A létrehozási idők az oprendszer időosztása miatt nem
// reprodukálhatóak. A különbség ennek ellenére szignifikáns!
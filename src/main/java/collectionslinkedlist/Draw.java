package collectionslinkedlist;

import java.util.*;

public class Draw {
    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber)
            throw new IllegalArgumentException("drawCount must be less then 8!");
        LinkedList<Integer> numbers = createBalls(maxNumber);
        Collections.shuffle(numbers);
        Set<Integer> result = draw(numbers, drawCount);
        return result;
    }

    private Set<Integer> draw(LinkedList<Integer> numbers, int drawCount) {
        Set<Integer> result = new TreeSet<>();
        while (result.size() < drawCount) {
            result.add((Integer) ((Queue) numbers).poll());
        }
        return result;
    }

    private LinkedList<Integer> createBalls(int maxNumber) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        while (i < maxNumber) {
            result.add(++i);
        }
        return result;
    }
}
//Hasonlít a korábbi feladatra, itt is véletlen számok kihúzásáról van szó, ám más az implementáció.
//
// A véletlen számok létrehozása azonos is lehet, de ArrayList helyett itt LinkedList a konkrét implementáció.
// A húzásnál használjuk ki azt, hogy a kapott LinkedList mint Queue is kezelhető,
// és a Queue poll() metódusával szedhetők ki a nyerő számok.
//
//Hibakezelés
//  Ha a public Set<Integer> drawNumbers(int drawCount, int maxNumber) metódust rossz paraméterekkel hívták meg
//  (több vagy ugyanannyi számot kellene kihúzni, mint amennyit generál),
//  a metódus dobjon egy IllegalArgumentException kivételt.
//
//Megvalósítás
//  A kapott List típust át kell alakítani Queue típussá (közvetlen cast nem lehetséges!)
//  és a kihúzott számok sorba rendezése TreeSet alkalmazásával történjen.
//
//publikus metódusok:
// public Set<Integer> drawNumbers(int drawCount, int maxNumber)
package collectionshashset;

import java.util.*;

public class RandomStringGenerator {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set<String> result = new HashSet<>(stringCollection);
        return result;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        Set<String> result = new HashSet<>();
        for (String one : setA) {
            if (setB.contains(one)) {
                result.add(one);
            }
        }
        return result;
    }

    public List<String> createStrings(int len, int pieces) {
        List<String> result = new ArrayList<>(pieces);
        for (int i = 0; i < pieces; ++i) {
            result.add(randomString(len));
        }
        return result;
    }

    private String randomString(int len) {
        StringBuilder result = new StringBuilder(len);
        Random rnd = new Random();
        for (int i = 0; i < len; ++i) {
            result.append((char) ('a' + rnd.nextInt(26)));
        }
        return result.toString();
    }
}
//Szolgáltatásokat készítünk,
// egyrészt egy nagy elemszámú, random módon generált String kollekcióból akarjuk kiszűrni az egyedi elemeket,
// másrész két különböző String halmazból akarjuk kinyerni a közös elemeket.
//
//A StringsHandler osztályban a következő publikus metódusok találhatók (ezek persze a tesztesetekből is következnek):
//
//public Set<String> filterUniqueStrings(Collection<String> stringCollection)
//public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB)
//
//  Feltételezzük, hogy a véletlenszerűen generált String objektumok között valamennyi azonos is található.
//  Feltételezzük, hogy két (vagy több) egyénileg, véletlenszerűen generált String kollekcióban számos azonos
//      String található.
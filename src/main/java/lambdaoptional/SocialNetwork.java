package lambdaoptional;

import java.util.*;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> members;

    public SocialNetwork() {
        members = new ArrayList<>();
    }

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> selector) {
        //      assertFalse(socialNetwork.findFirst(m -> m.getName().equals("Joe")).isPresent());
        //      assertEquals("John Doe", socialNetwork.findFirst(m -> m.getName().equals("John Doe")).get().getName());
        for (Member one : members) {
            if (selector.test(one)) {
                return Optional.of(one);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.size() == 0) return Optional.empty();

        int pieces = 0;
        for (Member one : members) {
            pieces += one.getSkills().size();
        }
        return Optional.of((.0 + pieces) / members.size());
    }
}
//Hozz létre egy közösségi hálózatot, melyen kereséseket lehet végezni.
//
//Hozz létre egy Member osztályt, name, skills (mely egy List<String>), gender attribútumokkal.
//
//Hozz létre egy SocialNetwork osztályt, mely Member objektumokat képes tárolni.
//
//A findFirst metódusa paraméterként egy keresési feltételt kap. Visszatérési típusa Optional.
//  Ha talál a keresési feltételnek megfelelő tagot, akkor az elsőt adja vissza,
//  ha nem talál, üres értékkel tér vissza.
//
//A averageNumberOfSkills üres értékkel tér vissza, ha a közösségi háló nem tartalmaz tagot.
// Ellenkező esetben átlagolja a tagok szakértelmének számát, és azzal tér vissza.
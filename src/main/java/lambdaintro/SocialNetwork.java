package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

//    public List<Member> getMembers() {
//        return Collections.unmodifiableList(members);
//    }

    public List<Member> findMembersBy(Predicate<Member> selector) {
        //      m ->m.getSkills().contains("Java")
        List<Member> result = new ArrayList<>();
        for (Member one : members) {
            if (selector.test(one)) {
                result.add(one);
            }
        }
        return result;
    }

    public void applyToSelectedMembers(Predicate<Member> selector, Consumer<Member> task) {
        //      m -> m.getGender() == Sex.FEMALE && m.getSkills().contains("db"),
        //      m -> m.sendMessage("Dear " + m.getName() + "!"));
        List<Member> selected = findMembersBy(selector);
        for (Member one : selected) {
            task.accept(one);
        }
    }

    public List<String> transformMembers(Function<Member, String> task) {
        //      List<String> names = socialNetwork.transformMembers(Member::getName);
        List<String> result = new ArrayList<>();
        for (Member one : members) {
            result.add(task.apply(one));
        }
        return result;
    }
}
//Hozz létre egy közösségi hálózatot, melyben a fejvadászok mindenféle műveletet tudnak végezni a tagokkal.
//
//Hozz létre egy Member osztályt, name, skills (mely egy List<String>), gender és messages (List<String>) attribútumokkal.
//Hozz létre benne egy sendMessage(String) metódust, mely a paraméterként kapott üzenetet beteszi a messages listába.
//
//Hozz létre egy SocialNetwork osztályt, mely Member objektumokat képes tárolni.
// A findMembersBy() metódusa a paraméterként átadott feltétel alapján kigyűjti a tagokat.
// A applyToSelectedMembers() a paraméterként átadott feltételnek megfelelő tagokon végez valamilyen műveletet
//  (2. paraméterként átadva).
// A transformMembers() metódus minden tagon valamilyen transzformációt végez.
//
//Implementációs javaslat
// Egy feltétel átadásához használj Predicate interfészt.
// Egy művelet átadásához használj Consumer interfészt.
// Konvertáláshoz használj Function interfészt.
//
//A transformMembers() metódus elég erősen használ generikust, nézd meg, hogy kell a metódusban definiálni, és használni
//is generikust.
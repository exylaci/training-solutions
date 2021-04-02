package exam04retake.hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CleaningService {
    private List<Cleanable> estates = new LinkedList<>();

    public void add(Cleanable estate) {
        estates.add(estate);
    }

    public List<Cleanable> getCleanables() {
        return Collections.unmodifiableList(estates);
    }

    public int cleanAll() {
        int price = estates
                .stream()
                .mapToInt(Cleanable::clean)
                .sum();

        estates = new LinkedList<>();
        return price;
    }

    public String getAddresses() {
        return estates
                .stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }

    public int cleanOnlyOffices() {
        int price = 0;
        Iterator<Cleanable> iterator = estates.iterator();
        Cleanable oneEstate;

        while (iterator.hasNext()) {
            oneEstate = iterator.next();
//            if (oneEstate instanceof Office) {            //Type enum nélkül egyszeerűbb a program, viszont
            if (oneEstate.getType()==Type.OFFICE) {         //így könnyen bővíthető újabb épület típusok esetén.
                price += oneEstate.clean();
                iterator.remove();
            }
        }
        return price;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return estates
                .stream()
                .filter(sameAddress(address))
                .collect(Collectors.toList());
    }

    private Predicate<Cleanable> sameAddress(String address) {
        return a -> a.getAddress().contains(address);
    }
}

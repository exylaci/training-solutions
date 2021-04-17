package gyaxi.kovacseni.snowwhite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SnowWhite {
    private List<Dwarf> dwarves;

    public SnowWhite(List<Dwarf> dwarves) {
        this.dwarves = dwarves;
    }

    public List<Dwarf> getSevenDwarfs() {
        return new ArrayList<>(dwarves);
    }

    public List<Dwarf> getSevenDwarfsOrderedByNames() {
        return dwarves
                .stream()
                .sorted(Comparator.comparing(Dwarf::getName))
                .collect(Collectors.toList());
    }

    public List<Dwarf> getSevenDwarfsOrderedByAges() {
        return dwarves
                .stream()
                .sorted(Comparator.comparing(Dwarf::getAge))
                .collect(Collectors.toList());
    }
}
package kepesitovizsga.hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {
    private List<MilitaryUnit> units = new ArrayList<>();

    public Army() {
    }

    public int getArmySize() {
        return units.size();
    }


    public void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    public int getArmyDamage() {
        return units.stream().mapToInt(MilitaryUnit::doDamage).sum();
    }

    public void damageAll(int damage) {
        Iterator<MilitaryUnit> iterator = units.iterator();

        while (iterator.hasNext()) {
            MilitaryUnit unit = iterator.next();
            unit.sufferDamage(damage);
            if (unit.getHitPoints() < 25) {
                iterator.remove();
            }
        }
    }
}
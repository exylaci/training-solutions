package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public enum LengthUnit {
    milliméter(true,1),
    centiméter(true,10),
    méter(true,1000),
    yard(false,914.4),
    foot(false,304.8),
    inch(false,25.4);

    private boolean si;
    private double length;

    LengthUnit(boolean si, double length) {
        this.si = si;
        this.length = length;
    }

    public boolean isSi() {
        return si;
    }

    public double getLength() {
        return length;
    }

    public static List<LengthUnit> siUnits(){      //bonusz feladatban ide kerülne a metódus, de a static miatt nem tetszik
        List<LengthUnit> si = new ArrayList<>();
        for (LengthUnit lengthUnit : LengthUnit.values() ) {
            if (lengthUnit.isSi()){
                si.add(lengthUnit);
            }
        }
        return si;
    }
}

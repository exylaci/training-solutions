package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter u = new UnitConverter();
        System.out.print("1 inch = ");
        System.out.print(u.convert( new BigDecimal(1),LengthUnit.inch,LengthUnit.méter));
        System.out.println(" méter.");

        System.out.println("\n All units:");
        for (LengthUnit l : LengthUnit.values() ) {
            System.out.println(l.name());
        }

        System.out.println("\n SI units:");
        System.out.println(u.siUnits());

        System.out.println("\n Bonusz SI units:");
        System.out.println(LengthUnit.siUnits());  //csak static metódusnak tudom meghívni, mert nem lehet példányosítani
    }
}

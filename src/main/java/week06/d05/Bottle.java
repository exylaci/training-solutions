package week06.d05;

public class Bottle {
    private BottleType type;
    private int filledUntil;

    public static Bottle of(BottleType bottleType) {
        if (bottleType == null) {
            throw new IllegalArgumentException("Bottle type is a must!");
        }
        Bottle bottle = new Bottle();
        bottle.type = bottleType;
        return bottle;
    }

    public int fill(int fillAmount) {
        int newfilledUntil = filledUntil + fillAmount;
        if (newfilledUntil > type.getMaximumAmount()) {
            throw new RuntimeException("The bottle would be overfilled!");
        }
        filledUntil = newfilledUntil;
        return filledUntil;
    }
}
//Készíts a week06d05 csomagban egy Bottle nevű osztályt, amelynek van 2 attribútuma:
// BottleType type és
// int filledUntil.

// A BottleType legyen felsorolásos típus az alábbi értékekkel: GLASS_BOTTLE és PET_BOTTLE, .

// A Bottle nevű osztálynak legyen egy static metódusa of néven,
//   mely paraméterként egy BottleType-ot vár és
//   visszaad egy új Bottle objektumot amelyet a megadott paraméter alapján hoz létre.
//
// A Bottle osztálynak legyen egy fill metódusa,
//   mely egy int fillAmount paramétert vár.
//   A fill meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a Bottle objektum.
//     Az ehhez szükséges int maximumAmount mezőt a BottleType tartalmazza!
//     Ha túlcsordulna a Bottle objektum, akkor dobjunk kivételt!
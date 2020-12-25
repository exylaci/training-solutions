package week06.d05;

public class Biscuit {
    private BiscuitType biscuitType;
    private int gramAmount;

    public static Biscuit of(BiscuitType biscuitType, int gramAmount) {
        return new Biscuit(biscuitType, gramAmount);
    }

    private Biscuit(BiscuitType biscuitType, int gramAmount) {
        this.biscuitType = biscuitType;
        this.gramAmount = gramAmount;
    }

    public BiscuitType getBiscuitType() {
        return biscuitType;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    @Override
    public String toString() {
        return String.format("Biscuit type: %s amount: %d gramm", biscuitType, gramAmount);
    }
}
//Készíts egy Biscuit nevű osztályt, amelynek van két attribútuma:
//  BiscuitType type és i
//  nt gramAmount.
// A BiscuitType legyen felsorolásos típus a három kedvenc kekszfajtáddal!
// A Biscuit nevű osztálynak legyen egy
//  static metódusa of néven,
//  nmely paraméterként egy BiscuitType-ot,
//  és egy int gramAmount-ot vár és
//  visszaad egy új Biscuit objektumot amelyet a megadott paraméterek alapján hoz létre.
//
//Bónusz feladat: konzolra írás esetén a Biscuit jelenítse meg a type és a gramAmount mezőket!
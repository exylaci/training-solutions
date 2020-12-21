package week09.d02;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {


    public enum Methodology {NAGYON_LASSU_MODSZER, FAVAGO_MODSZER, LAGNAGYOBB_KOZOS_OSZTO_MODSZERE, TRUKKOS, PRIMTENYEZOS_FELBONTASSAL;}

    public static int smallestCommonMultiple(int one, int two) {
        return smallestCommonMultiple(one, two, Methodology.PRIMTENYEZOS_FELBONTASSAL);
    }

    public static int smallestCommonMultiple(int one, int two, Methodology methodology) {
        if (one < 1 || two < 1) throw new IllegalArgumentException("Must be positive number!");
        if (methodology == null) throw new IllegalArgumentException("Unknown methodology!");

        MathAlgorithms m = new MathAlgorithms();

        switch (methodology) {
            case NAGYON_LASSU_MODSZER:
                return m.nagyonLassuModszer(one, two);
            case FAVAGO_MODSZER:
                return m.favagoModszer(one, two);
            case LAGNAGYOBB_KOZOS_OSZTO_MODSZERE:
                return m.legnagyobbKozosOsztoSegitsegevel(one, two);
            case TRUKKOS:
                return m.trukkosen(one, two);
            case PRIMTENYEZOS_FELBONTASSAL:
                return m.primtenyezosFelbontassal(one, two);
        }
        return 0;
    }

    private int nagyonLassuModszer(int one, int two) {
        int result = 1;
        while (result % one != 0 || result % two != 0) {
            ++result;
        }
        return result;

    }

    private int favagoModszer(int one, int two) {
        int result = Math.max(one, two);
        while (result % Math.min(one, two) != 0)
            result += Math.max(one, two);
        return result;
    }

    private int legnagyobbKozosOsztoSegitsegevel(int one, int two) {
        return (int) ((long) one) * two / getgreatestCommonDivisor(one, two);
    }

    private int getgreatestCommonDivisor(int one, int two) {
        if (Math.max(one, two) % Math.min(one, two) == 0) {
            return Math.min(one, two);
        }
        return getgreatestCommonDivisor(Math.max(one, two) % Math.min(one, two), Math.max(one, two));
    }

    private int trukkosen(int one, int two) {
        return (int) ((long) one) * two / week08.d05.MathAlgorithms.greatestCommonDivisor(one, two);
    }

    private int primtenyezosFelbontassal(int one, int two) {
        List<Integer> primsOfOne = getPrims(one);
        List<Integer> primsOfTwo = getPrims(two);
        List<Integer> unio = getUnio(primsOfOne, primsOfTwo);

        return multiply(unio);
    }

    private int multiply(List<Integer> value) {
        int result = 1;
        for (Integer one : value) {
            result *= one;
        }
        return result;
    }

    private List<Integer> getUnio(List<Integer> primsOfOne, List<Integer> primsOfTwo) {
        List<Integer> result = new ArrayList<>(primsOfOne);
        List<Integer> temp = new ArrayList<>(primsOfTwo);

        for (Integer one : primsOfOne) {
            for (int i = 0; i < temp.size(); ++i) {
                if (one == temp.get(i)) {
                    temp.remove(i);
                    break;
                }
            }
        }
        result.addAll(temp);

        return result;
    }

    private List<Integer> getPrims(int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= value; ++i) {
            if (isPrim(i)) {
                while (value % i == 0) {
                    result.add(i);
                    value /= i;
                }
            }
        }
        return result;
    }

    private boolean isPrim(int value) {
        for (int i = 2; i <= Math.sqrt(value); ++i) {
            if (value % i == 0) return false;
        }
        return true;
    }
}
// A legkisebb közös osztó megkeresése 5 féle módon.
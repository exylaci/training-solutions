package enumtype.enumplusplus;

import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

public class PlusPlus {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Sequence.values()));

        Sequence s = Sequence.HATODIK;
        Sequence next = Sequence.values()[ (s.ordinal()+1) % Sequence.values().length ];

        System.out.println(s + "+1="+next);
            }
}

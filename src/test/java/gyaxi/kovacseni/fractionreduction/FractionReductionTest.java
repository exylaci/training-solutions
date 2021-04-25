package gyaxi.kovacseni.fractionreduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionReductionTest {

    @Test
    void testGetNumberOfNotReductiveFractions() {
        Assertions.assertEquals(48, new FractionReduction().getNumberOfNotReductiveFractions());
    }
}
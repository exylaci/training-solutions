package enumtype.unit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    public final int PRECISION = 4;

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target){
        double resoult = length.doubleValue() / target.getLength() * source.getLength();
        return new BigDecimal( resoult ).round(new MathContext(PRECISION));
    }

    public List<LengthUnit> siUnits(){
        List<LengthUnit> si = new ArrayList<>();
        for (LengthUnit lengthUnit : LengthUnit.values() ) {
            if (lengthUnit.isSi()){
                si.add(lengthUnit);
            }
        }
    return si;
    }
}

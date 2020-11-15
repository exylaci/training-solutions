package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget( List<Salesperson> salespersons ){
        Salesperson it = null;
        int min = Integer.MAX_VALUE;
        for ( Salesperson one : salespersons ) {
            if ( one.getDifferenceFromTarget() < min ){
                min = one.getDifferenceFromTarget();
                it = one;
            }
        }
        return it;
    }
}

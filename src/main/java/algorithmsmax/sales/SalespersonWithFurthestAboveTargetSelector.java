package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons){
        Salesperson it = null;
        int max = Integer.MIN_VALUE;
        for ( Salesperson one : salespersons ) {
            if ( one.getDifferenceFromTarget() > max ){
                max = one.getDifferenceFromTarget();
                it = one;
            }
        }
        return it;
    }
}

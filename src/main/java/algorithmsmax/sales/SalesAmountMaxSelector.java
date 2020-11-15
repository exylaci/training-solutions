package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons){
        Salesperson max = null;
        int maxAmount = Integer.MIN_VALUE;
        for ( Salesperson one : salespersons ) {
            if ( one.getAmount() > maxAmount ){
                maxAmount=one.getAmount();
                max = one;
            }
        }
        return max;
    }
}

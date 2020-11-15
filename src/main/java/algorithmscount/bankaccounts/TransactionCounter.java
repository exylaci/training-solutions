package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int limit){
        int counter = 0;
        for ( Transaction one : transactions ) {
            if ( one.getAmount() < limit ){
                ++counter;
            }
        }
        return counter;
    }
}

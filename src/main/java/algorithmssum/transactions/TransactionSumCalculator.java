package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {


    public int sumAmountOfCreditEntries(List<Transaction> transactions){
        int sum = 0;
        for ( Transaction one : transactions ) {
            if ( one.isCredit() ){
                sum += one.getAmount();
            }
        }
        return sum;
    }
}

package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {
    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime,int amount){
        for ( Transaction one : transactions ) {
//            System.out.println(one.getAmount()>amount);
//            System.out.println(one.getDateOfTransaction().isAfter(startTime));
//            System.out.println(one.getDateOfTransaction().isBefore(endTime));
//            System.out.println(one.isCredit());
            if (one.getAmount()>amount
                    && one.getDateOfTransaction().isAfter(startTime)
                    && one.getDateOfTransaction().isBefore(endTime)
                    && one.isCredit()){
//                System.out.println("-->True");
                return true;
            }
            System.out.println();
        }
//        System.out.println("-->False");
        return false;
    }
}

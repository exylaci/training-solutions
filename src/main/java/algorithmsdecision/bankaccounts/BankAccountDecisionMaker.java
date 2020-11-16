package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accounts,int number){
        for ( BankAccount one : accounts ) {
            if ( one.getBalance() >= number ){
                return true;
            }
        }
        return false;
    }
}

package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {
    public void executeTransactions(List<Transaction> transactions,  List<BankAccount> accounts){
        for ( int trn=0 ; trn < transactions.size() ; ++trn){
            boolean success = false;
            for (int acc = 0; acc < accounts.size() ; ++acc){
                if ( transactions.get(trn).getAccountNumber().equals( accounts.get(acc).getAccountNumber() )) {
                    if ( transactions.get(trn).isCredit()){
                        success = accounts.get(acc).deposit( transactions.get(trn).getAmount() );
                    }else{
                        success = accounts.get(acc).withdraw( transactions.get(trn).getAmount() );
                    }
                }
            }
            if (success){
                transactions.get(trn).setTransactionStatus(TransactionStatus.SUCCEEDED);
            }else{
                transactions.get(trn).setTransactionStatus(TransactionStatus.PENDING);
            }
        }
    }
}

// megkap egy tranzakció listát és egy számlák listát paraméterként és végrehajtja az összes tranzakciót, azaz
//   minden tranzakcióhoz megkeresi az érintett számlát és
//   ha megtalálja, akkor a creditOrDebit értéke alapján a számla megfelelő metódusának
//      (withdraw vagy deposit) meghívásával módosítja a számla egyenlegét.
//   Sikeres végrehajtás esetén a
//          tranzakció státuszát állítsd SUCCEEDED-re,
//          különben tedd PENDING-re.
//
// Feltételezzük természetesen, hogy a számlaszámok egyediek a számlák listában.

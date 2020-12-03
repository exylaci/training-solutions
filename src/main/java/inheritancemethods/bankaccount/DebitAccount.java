package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;
    public static double COST = 3.0;
    public static long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        if ( accountNumber==null || accountNumber.isBlank()){
            throw new IllegalArgumentException("Account number is a must!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount){
        long result = (long)Math.floor(amount*COST/100);
        if (result<MIN_COST){
            result=MIN_COST;
        }
        return result;
    }

    public boolean transaction(long amount){
        long newBalance=balance-amount-costOfTransaction(amount);
        if (newBalance<0){
            return false;
        }
        balance=newBalance;
        return true;
    }

    public void balanceToZero(){
        balance=0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}

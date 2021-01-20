package classstructureintegrate;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
    public void transfer(BankAccount to,int amount){
        this.balance -= amount;
        to.deposit(amount);
    }
    public String getInfo(){
        //Tóth Kálmán (10073217-12000098-67341590): 103400 Ft
        return owner +" ("+accountNumber+"): "+balance+" Ft";
    }
}

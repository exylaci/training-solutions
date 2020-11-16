package algorithmsdecision.bankaccounts;

public class BankAccount {
    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(int amount){
        if ( amount > balance ){
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean deposit(int amount){
        balance += amount;
        return true;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}


//    nameOfOwner, a számla tulajdonosának neve
//    accountNumber, a számlaszám
//    balance, egyenleg
//
//Legyen az osztálynak withdraw és deposit metódusa paraméterként kapott összeg levételére ill. betételére a számlára.
//
//Feladat egy metódus megírása, ami eldönti van-e olyan számla, amelynek az aktuális egyenlege meghaladja a paraméterként kapott alsó határt.
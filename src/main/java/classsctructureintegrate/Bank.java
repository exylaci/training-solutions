package classsctructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccountOne = new BankAccount(
                "10073217-12000098-67341590",
                "Gábor Áron",
                1000);
        BankAccount bankAccountTwo = new BankAccount(
                "53434543-34453455-53234660",
                "Nagy Sándor",
                2000);
        System.out.println(bankAccountOne.getInfo());
        System.out.println(bankAccountTwo.getInfo());

        bankAccountOne.deposit(500);
        System.out.println(bankAccountOne.getInfo());

        bankAccountOne.transfer(bankAccountTwo,250);
        System.out.println(bankAccountOne.getInfo());
        System.out.println(bankAccountTwo.getInfo());

        bankAccountTwo.withdraw(3000);
        System.out.println(bankAccountTwo.getInfo());
    }
}

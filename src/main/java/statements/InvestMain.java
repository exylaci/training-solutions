package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        System.out.println("Amount of fund:");
        Scanner scanner = new Scanner(System.in);
        int fund = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Interest rate:");
        int interestRate = scanner.nextInt();
        scanner.nextLine();
        Investment investment = new Investment(fund,interestRate);
        System.out.println("Fund: " + investment.getFund());
        System.out.println("Yield for 50 days: "+investment.getYield(50));
        System.out.println("Dispatch after 80 days: " + investment.close(80));
        System.out.println("Dispatch after 90 days: " + investment.close(90));
    }
}


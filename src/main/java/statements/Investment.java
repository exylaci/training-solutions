package statements;

public class Investment {
    private double cost;
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        active=true;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days){
        if (days>365) days=365;
        return fund * (days/365.0) * interestRate/100.0;
    }

    public double close(int days){
        if (!active) return 0;
        active=false;
        return  (getYield(days)+fund) * (1 - 0.3/100);
    }
}

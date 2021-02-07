package week14.d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String client;
    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = new ArrayList<>(monthlyPrices);
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setMonthlyPrices(List<Integer> monthlyPrices) {
        this.monthlyPrices = monthlyPrices;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "client='" + client + '\'' +
                ", monthlyPrices=" + monthlyPrices +
                '}';
    }
}

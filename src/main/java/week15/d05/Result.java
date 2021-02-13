package week15.d05;

public class Result implements Comparable{
    private String country;
    private Double rate;

    public Result(String country, Double rate) {
        this.country = country;
        this.rate = rate;
    }

    public String getCountry() {
        return country;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Result{" +
                "country='" + country + '\'' +
                ", rate=" + rate +
                "}\n";
    }

    @Override
    public int compareTo(Object o) {
        return this.rate-((Result) o).getRate() >0 ? -1:1;
    }
}

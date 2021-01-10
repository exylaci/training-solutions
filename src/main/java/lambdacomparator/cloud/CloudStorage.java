package lambdacomparator.cloud;

public class CloudStorage implements Comparable {
    private String provider;
    private int space;
    private PayPeriod payPeriod;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.payPeriod = payPeriod;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Object o) {
        // 1000 GB-ra eső éves díj nagysága adja.
        //    private int space;
        //    private double price;
        return Double.compare(
                (payPeriod == null ? 0 : price / space / payPeriod.getLength()),
                (((CloudStorage) o).payPeriod == null ? 0 : ((CloudStorage) o).price / ((CloudStorage) o).space / ((CloudStorage) o).payPeriod.getLength()));
    }
}
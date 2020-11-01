package classsctructureconstructors;

public class Store {
    private String product;
    private int stock;

    public Store(String product) {
        this.product = product;
        this.stock=0;
    }
    public int store(int pieces){
        stock+=pieces;
        return stock;
    }
    public int dispatch(int pieces){
        stock-=pieces;
        return stock;
    }
    public String getStore(){
        return product + ": " + stock + " piece(s)";
    }
}

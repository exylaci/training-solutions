package classsctructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store storeOne = new Store("one product");
        Store storeTwo = new Store("different product");

        System.out.println(storeOne.store(35));
        System.out.println(storeTwo.store(5));
        System.out.println(storeOne.dispatch(17));
        System.out.println(storeTwo.dispatch(67));

        System.out.println(storeOne.getStore());
        System.out.println(storeTwo.getStore());
    }
}

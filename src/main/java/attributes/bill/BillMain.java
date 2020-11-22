package attributes.bill;

import classsctructureintegrate.Bank;

public class BillMain {
    public static void main(String[] args) {
        Bill bills = new Bill();
        bills.addItem(new Item("váza",3,4.));
        bills.addItem(new Item("virág",27,5.6));
        bills.addItem(new Item("csomagolás",5,6.7));

        System.out.println( bills.calculateTotalPrice() );
    }
}

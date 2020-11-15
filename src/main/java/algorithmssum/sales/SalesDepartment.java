package algorithmssum.sales;

import filescanner.library.Library;

import java.util.ArrayList;
import java.util.List;

public class SalesDepartment {
    private List<Salesperson> salesPeople = new ArrayList<>();

    public void add(Salesperson salesperson){
        salesPeople.add(salesperson);
    }

    public int totalAmount(){
        int sum = 0;
        for (Salesperson one : salesPeople ) {
            sum += one.getAmount();
        }
        return sum;
    }
}

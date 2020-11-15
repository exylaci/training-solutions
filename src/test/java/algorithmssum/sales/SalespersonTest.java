package algorithmssum.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalespersonTest {

    @Test
    public void testCreateSalesperson() {
        Salesperson salesperson = new Salesperson("Jack", 1500);
        assertEquals("Jack", salesperson.getName());
        assertEquals(1500, salesperson.getAmount());
    }

   @Test
    public void testTotalAmount() {
        SalesDepartment salesDepartment = new SalesDepartment();
        salesDepartment.add( new Salesperson("Jack", 1500));
        salesDepartment.add( new Salesperson("Joe", 3500));
        salesDepartment.add( new Salesperson("Jane", 500));
        assertEquals(5500, salesDepartment.totalAmount());
    }

}
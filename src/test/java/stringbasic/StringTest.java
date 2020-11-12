package stringbasic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    public String createStringForHeap(){
        String sh1 = new String("azonos tartalom");             //Sztring a HEAP-ben.
        return sh1;
    }
    public String createStringForPool(){
        String sp1 = "azonos tartalom";                                //Sztring a POOL-ban.
        String sp2 = new String("azonos tartalom)").intern();   //Sztring a POOL-ban.
        return sp1;
    }
    public static void main(String[] args) {
        StringTest poolHeap = new StringTest();

        assertEquals(true,poolHeap.createStringForHeap().equals(poolHeap.createStringForHeap()));
        assertEquals(false, poolHeap.createStringForHeap() == poolHeap.createStringForHeap());

        assertEquals(true, poolHeap.createStringForPool().equals(poolHeap.createStringForPool()));
        assertEquals(true, poolHeap.createStringForPool() == poolHeap.createStringForPool());

        assertEquals(true, poolHeap.createStringForPool().equals(poolHeap.createStringForHeap()));
        assertEquals(false, poolHeap.createStringForPool() == poolHeap.createStringForHeap());
    }
}

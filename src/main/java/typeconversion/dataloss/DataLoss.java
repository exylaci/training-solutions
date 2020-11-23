package typeconversion.dataloss;

public class DataLoss {
    public void dataLoss(){
        float f;
        int counter = 0;

        for ( long l=0 ; l<= Long.MAX_VALUE ; ++l ){
            f = l;
            if ( l != (long) f ){
                System.out.printf("number=%d  eltérés=%2d  bits=%.0f  in binary format=%s\n",
                        l,
                        l-(long)f,
                        Math.ceil( Math.log(l)/Math.log(2) ),
                        Integer.toBinaryString((int)l));
                ++counter;
                if ( counter == 3 ) {
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        DataLoss d = new DataLoss();
        d.dataLoss();
    }
}

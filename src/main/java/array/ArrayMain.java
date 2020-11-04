package array;

public class ArrayMain {
    public static void main(String[] args) {
        System.out.println("A hét napjai:");
        String[] week = {"hétfő","kedd","szerda","csütörtök","péntek","szombat","vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);
        System.out.println();

        System.out.println("2 hatványai");
        int[] exponents = new int[5];
        for(int i=0 ; i<5 ; ++i ){
            exponents[i]=(int)Math.pow(2,i);
        }
        for(int exponent : exponents ){
            System.out.println(exponent);
        }
        System.out.println();

        System.out.println("Boolean tömb.");
        boolean[] bool = new boolean[6];
        for (int i=0 ; i<6 ; ++i){
            bool[i]=i%2==1;
        }
        for (boolean oneBool : bool){
            System.out.println(oneBool);
        }
    }
}

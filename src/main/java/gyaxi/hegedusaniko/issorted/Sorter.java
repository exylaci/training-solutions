package gyaxi.hegedusaniko.issorted;

public class Sorter {
    // gyors algoritmus
    public static boolean isSorted(double[] numbers) {
        int index=0;
        int lastIndex= numbers.length-1;
        while(index<lastIndex){
            if(numbers[index]>numbers[++index]){
                return false;
            }
        }
        return true;
    }

//    átlátható kód
//    public static boolean isSorted(double[] numbers) {
//        for (int index=0; index < numbers.length - 1; ++index) {
//            if (numbers[index] > numbers[index + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }

}

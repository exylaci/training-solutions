package week07.d1;

public class Fibonacci {

    public static long fib(int index) {
        if (index<1){
            return 0;
        }
        long number = 1;
        long previous = 0;
        long beforePrevius = 1;
        for (int i = 1; i <= index; ++i) {
            try {
                number=Math.addExact(previous,beforePrevius);
            }catch (ArithmeticException e){
                throw new IllegalArgumentException("Túl sokadik elemet kéred. :(");
            }
            number = previous + beforePrevius;
            beforePrevius = previous;
            previous = number;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println( fib(3));
        System.out.println( fib(10));
    }
}

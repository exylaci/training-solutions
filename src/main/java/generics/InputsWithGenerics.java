package generics;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InputsWithGenerics {

    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        InputsWithGenerics in = new InputsWithGenerics();

        in.asker();
    }

    private void asker() {
        String name = inputData("neved: ", "Hibás név!", this::inputString, this::checkName);
        int age = inputData("életkor: ", "18 és 150 között kell legyen!", this::inputInt, this::checkAge);

        System.out.println(name + ", " + age);
    }

    private <T> T inputData(String question, String error, Supplier<T> supplier, Predicate<T> predicate) {
        T value;
        boolean correct;
        do {
            System.out.print(question);
            value = supplier.get();
            correct = predicate.test(value);
            if (!correct) {
                System.out.println(error);
            }
        } while (!correct);
        return value;
    }

    private boolean checkName(String value) {
        return value.contains(" ");
    }

    private boolean checkAge(int value) {
        return value > 18 && value < 150;
    }

    private String inputString() {
        return scanner.nextLine();
    }

    private int inputInt() {
        String value = scanner.nextLine();
        while (!value.matches("[0-9]{1,10}")) {
            System.out.println("Csak számokat írj!");
            value = scanner.nextLine();
        }
        return Integer.parseInt(value);
    }
}

package generics;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InputsWithGenerics {
    public static final String PATH_PATTERN = "[[A-Za-z]:[\\\\/]]?[\\w[\\\\/]]*[\\w]+\\.[A-Za-z]+";
    public static final String EMAIL_PATTERN = "[a-z0-9]+[a-z0-9\\.-]*@([a-z0-9-]+\\.)+[a-z]{2,4}";

    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        InputsWithGenerics in = new InputsWithGenerics();

        in.asker();
    }

    private void asker() {
        String file = inputData("fájl: ", "Hibás path!", this::inputString, this::checkFile);
        String email = inputData("email: ", "Hibás email!", this::inputString, this::checkEmail);
        int age = inputData("életkor: ", "18 és 150 között kell legyen!", this::inputInt, this::checkAge);

        System.out.println(file +" "+email + ", " + age);
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

    private boolean checkFile(String value) {
        return value.matches(PATH_PATTERN);
    }

    private boolean checkEmail(String email) {
        return email.toLowerCase().matches(EMAIL_PATTERN)
                || !email.contains(".@");
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

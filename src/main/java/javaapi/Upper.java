package javaapi;

public class Upper {
    public static String toUpperCase(String inputText){
        return inputText.toUpperCase();
    }

    public static void main(String[] args) {
        String text = "Hello World!";
        System.out.println(Upper.toUpperCase(text));
    }
}

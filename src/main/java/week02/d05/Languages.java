package week02.d05;

import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaSript");
        for (String one : languages) {
            if (one.length() > 5) {
                System.out.println(one);
            }
        }
    }
}
//Hozz létre egy Languages osztályt, main metódussal!
// Ebben hozz létre egy listát, mely karakterláncokat tartalmaz!
// Vegyetek fel 3 elemet: Java, Python, JavaScript!
//
// Írd ki, az öt karakternél hosszabb programozási nyelveket!
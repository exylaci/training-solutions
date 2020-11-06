package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java","Python","JavaSript");
        for (String one: languages) {
            if(one.length() > 5){
                System.out.println(one);
            }
        }
    }
}

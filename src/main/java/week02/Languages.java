package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> programNyelvek = new ArrayList<>();
        programNyelvek.add("Java");
        programNyelvek.add("Python");
        programNyelvek.add("JavaSript");
        for (String one: programNyelvek) {
            if(one.length()>5){
                System.out.println(one);
            }
        }

    }

}

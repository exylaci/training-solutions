package week02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StringIntoArray {
    public static void main(String[] args) {
        String[] names = new String[5];
        Scanner scanner=new Scanner(System.in);

        for(int i=0; i<5 ; ++i){
            System.out.println("Kérem a(z) "+(i+1)+". nevet:");
            names[i]=scanner.nextLine();
        }
        for (int i =0 ; i<5 ; ++i ) {
            System.out.println((i+1)+". name"+names[i]);

        }
    }
}

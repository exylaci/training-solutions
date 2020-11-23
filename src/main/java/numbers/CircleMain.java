package numbers;

import primitivetypes.PrimitiveTypes;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        CircleMain cm = new CircleMain();

        for (int i = 1; i < 3; ++i) {
            Circle c = new Circle(cm.askDiameter());
            System.out.printf("Kerület=%.2f\n", c.perimeter());
            System.out.printf("Terület=%.2f\n", c.area());
        }
    }

    private int askDiameter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nÁtmérő: ");
        return scanner.nextInt();
    }
}

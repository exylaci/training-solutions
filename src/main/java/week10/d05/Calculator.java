package week10.d05;

import java.util.*;

public class Calculator {
    public static int MAX_NUMBER_TO_SUMMARISE = 4;

    public static void findMinMaxSum(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Nem kaptam adatot!");

        Arrays.sort(arr);

        int min = 0;
        int max = 0;
        for (int i = 0; i < MAX_NUMBER_TO_SUMMARISE && i < arr.length; ++i) {
            min += arr[i];
            max += arr[arr.length - 1 - i];
        }

        System.out.printf("A legkissebbek összege: %d%nA legnagyobbak összege: %d%n", min, max);
    }

    public static void findMinSum(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Nincs megadott adat!");

        int[] min = new int[MAX_NUMBER_TO_SUMMARISE];
        for (int i = 0; i < Math.min(MAX_NUMBER_TO_SUMMARISE, arr.length); ++i) {
            min[i] = arr[i];
        }
        if (arr.length > MAX_NUMBER_TO_SUMMARISE) {
            Arrays.sort(min);
        }

        for (int indexInArr = MAX_NUMBER_TO_SUMMARISE; indexInArr < arr.length; ++indexInArr) {
            for (int indexInMin = MAX_NUMBER_TO_SUMMARISE - 1; indexInMin >= 0; --indexInMin) {
                if (arr[indexInArr] < min[indexInMin]) {

                    for (int i=MAX_NUMBER_TO_SUMMARISE-1 ; i>0 ; --i){
                        if ( min[i-1]<arr[indexInArr]){
                            min[i]=min[i-1];
                        }else{
                            min[i]=arr[indexInArr];
                            break;
                        }
                    }

                    break;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < Math.min(MAX_NUMBER_TO_SUMMARISE, arr.length); ++i) {
            result += min[i];
        }

        System.out.println(String.format("A legkisebb számok összege: %d", result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String s = scanner.nextLine();
        while (!s.isBlank()) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Számot írj!");
            }
            s = scanner.nextLine();
        }
        int[] data = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            data[i] = numbers.get(i);
        }
        findMinSum(data);
    }
}
//Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa. A metódus feladata, hogy
// kiírja a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből. Példa: ha az arr
// tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16.
//
//
//Készítsünk egy Calculator nevű osztályt, melynek van egy findMinMaxSum(int[] arr) metódusa. A metódus feladata, hogy
// kiírja a legnagyobb és a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből. Példa:
// ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16 , a maximum összeg 3+5+7+9=24.A Calculator
// osztály tartalmazzon egy main metódust is, amely a konzolról olvassa be a számokat és azokból készít tömböt, amivel
// meghívja a findMinMaxSum metódust.
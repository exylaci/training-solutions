package collectionsautoboxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOperations {
    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>(numbers.length);

        for (int one : numbers) {
            result.add(one);
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println(result.toString());

        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        if (integerList == null) throw new IllegalArgumentException("IntegerList is a must!");

        int result = 0;
        for (Integer one : integerList) {
            result += one;
        }

        System.out.println(integerList.toString());

        return result;
    }

    public int sumIntegerObjects(Integer... integers) {
        int result = 0;
        for (Integer one : integers) {
            result += one;
        }

        System.out.println(Arrays.toString(integers));

        return result;
    }
}
//Implementáld az IntegerOperations osztályban a következő metódusokat!
//
//public List<Integer> createList(int... numbers)
//public int sumIntegerList(List<Integer> integerList)
//public int sumIntegerObjects(Integer... integers)
//
//Az egyes kollekciók esetében vizsgáljuk meg és értelmezzük a toString() metódus működését, a kiírás sorrendjének elemzésével.

//Megvalósítás
//  Használjunk varargs típusokat a paraméterek megadásához.
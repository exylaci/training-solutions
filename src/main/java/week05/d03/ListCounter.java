package week05.d03;

import java.util.List;

public class ListCounter {

    public int listCounter(List<String> lines) {
        if (lines == null) return 0;

        int counter = 0;
        for (String one : lines) {
            if (one != null && one.length() > 0 && one.substring(0, 1).toLowerCase().equals("a")) {
                ++counter;
            }
        }
        return counter;
    }

    public String listMerger(List<String> texts) {
        if (texts == null) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String text : texts) {
            if (text != null && text.length() > 0 && text.substring(0, 1).toLowerCase().equals("a")) {
                result.append(text);
            }
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }
}
//Írj egy olyan metódust a ListCounter osztályban,
// mely a kapott String listából összeszámolja azokat, amelyek a vagy A betűvel kezdődnek!
// Ha nulla elemű a tömb, vagy nincs benne ilyen elem, akkor nulla értéket adjon vissza!